package eShopGUI;

import java.sql.SQLException;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Link;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import eShop.ILoginSystem;
import eShop.ILoginSystem.*;

public class LoginForm extends Composite {
	private Text PasswordText;
	private Text UsernameText;
	private Label PasswordErrorLabel;
	private Label UsernameErrorLabel;
	public ILoginSystem LoginSystem;
	
	private Composite parent;
	private int style;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public LoginForm(Composite parent, int style, ILoginSystem sys) {
		super(parent, style);
		this.setSize(500,325);
		
		this.parent = parent;
		this.style = style;
		Label TitleLabel = new Label(this, SWT.NONE);
		TitleLabel.setText("eShop");
		TitleLabel.setFont(SWTResourceManager.getFont("Segoe UI", 48, SWT.NORMAL));
		TitleLabel.setBounds(160, 0, 179, 86);
		
		UsernameText = new Text(this, SWT.BORDER);
		UsernameText.setBounds(149, 121, 201, 21);
		
		PasswordText = new Text(this, SWT.BORDER);
		PasswordText.setBounds(149, 157, 201, 21);
		
		Label UsernameLabel = new Label(this, SWT.NONE);
		UsernameLabel.setText("Username");
		UsernameLabel.setBounds(77, 124, 55, 15);
		
		Label PasswordLabel = new Label(this, SWT.NONE);
		PasswordLabel.setText("Password");
		PasswordLabel.setBounds(77, 161, 55, 15);
		
		Button LoginButton = new Button(this, SWT.NONE);
		LoginButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Login();
			}
		});
		LoginButton.setText("Login");
		LoginButton.setBounds(263, 199, 87, 39);
		
		Link ForgotPasswordLink = new Link(this, 0);
		ForgotPasswordLink.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RecoverDetails();
			}
		});
		ForgotPasswordLink.setText("<a>Forgot your password?</a>");
		ForgotPasswordLink.setBounds(190, 265, 120, 15);
		
		Button SignUpButton = new Button(this, SWT.NONE);
		SignUpButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SignUp();
			}
		});
		SignUpButton.setText("Sign Up");
		SignUpButton.setBounds(149, 199, 87, 39);
		
		UsernameErrorLabel = new Label(this, SWT.WRAP);
		UsernameErrorLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		UsernameErrorLabel.setBounds(374, 115, 87, 32);
		UsernameErrorLabel.setText("Username doesn't exist!");
		UsernameErrorLabel.setVisible(false);
		
		PasswordErrorLabel = new Label(this, SWT.WRAP);
		PasswordErrorLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		PasswordErrorLabel.setBounds(374, 145, 101, 45);
		PasswordErrorLabel.setText("Username and password don't match!");
		PasswordErrorLabel.setVisible(false);
		
		LoginSystem = sys;

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private void Login() {
		try {
			LoginSystem.LoginToSystem(UsernameText.getText(), PasswordText.getText());
		} catch (UserNotFoundException e) {
			PasswordErrorLabel.setVisible(false);
			UsernameErrorLabel.setVisible(true);
		} catch (IncorrectPasswordException e) {
			PasswordErrorLabel.setVisible(true);
			UsernameErrorLabel.setVisible(false);
		} catch (SQLException e){
			System.out.println("Houston, we've got a problem...");
			throw new RuntimeException();
		}
	}
	
	private void SignUp() {
		setVisible(false);
		SignUpForm signUp = new SignUpForm(parent, style, this);
		parent.setSize(signUp.getSize());
		parent.pack();				

	}
	
	private void RecoverDetails() {
		setVisible(false);
		RecoverDetailsForm recover = new RecoverDetailsForm(parent, style, this);
		parent.setSize(recover.getSize());
		recover.pack();

		parent.pack();
	}

}
