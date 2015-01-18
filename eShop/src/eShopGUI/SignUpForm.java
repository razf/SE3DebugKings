package eShopGUI;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import eShop.ILoginSystem.*;

public class SignUpForm extends Composite {
	private Text UsernameText;
	private Text PasswordText;
	private Text PasswordText2;
	private Text EmailText;
	private Text CardNumberText;
	private Combo CardCompanyCombo;
	private LoginForm origin;
	private Composite parent;
	
	private Label passwordMatchError;
	private Label passwordStrengh;
	private Label invalidUsernameError;
	private Label usernameExistsError;
	private Label invalidEmailError;
	private Label emailExistsError;
	private Label invalidCardError;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public SignUpForm(Composite parent, int style, LoginForm origin) {
		super(parent, style);
		setSize(550,475);
		this.origin = origin;
		this.parent = parent;
		Label TitleLabel = new Label(this, SWT.NONE);
		TitleLabel.setText("eShop");
		TitleLabel.setFont(SWTResourceManager.getFont("Segoe UI", 48, SWT.NORMAL));
		TitleLabel.setBounds(160, 0, 179, 86);
		
		UsernameText = new Text(this, SWT.BORDER);
		UsernameText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				CheckUsernameValidity();
			}
		});
		UsernameText.setTouchEnabled(true);
		UsernameText.setBounds(200, 115, 179, 21);
		
		PasswordText = new Text(this, SWT.BORDER);
		PasswordText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				CheckPasswordsMatch();
			}
		});
		PasswordText.setBounds(200, 160, 179, 21);
		PasswordText.setEchoChar('•');
		
		PasswordText2 = new Text(this, SWT.BORDER);
		PasswordText2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				CheckPasswordsMatch();
			}
		});
		PasswordText2.setBounds(200, 221, 179, 21);
		PasswordText2.setEchoChar('•');
		
		EmailText = new Text(this, SWT.BORDER);
		EmailText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				CheckEmailValidity();
			}
		});
		EmailText.setText("");
		EmailText.setBounds(200, 266, 179, 21);
		
		Label UsernameLabel = new Label(this, SWT.NONE);
		UsernameLabel.setBounds(139, 118, 55, 15);
		UsernameLabel.setText("Username:");
		
		Label PasswordLabel = new Label(this, SWT.NONE);
		PasswordLabel.setBounds(139, 163, 55, 15);
		PasswordLabel.setText("Password:");
		
		Label PasswordConfLabel = new Label(this, SWT.NONE);
		PasswordConfLabel.setBounds(37, 224, 157, 15);
		PasswordConfLabel.setText("Please re-type your password:");
		
		Label EmailLabel = new Label(this, SWT.NONE);
		EmailLabel.setBounds(160, 269, 32, 15);
		EmailLabel.setText("Email:");
		
		Button SubmitButton = new Button(this, SWT.NONE);
		SubmitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Register();
			}
		});

		SubmitButton.setBounds(222, 401, 105, 46);
		SubmitButton.setText("Register");
		
		CardNumberText = new Text(this, SWT.BORDER);
		CardNumberText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				CheckCreditCardValidity();
			}
		});
		CardNumberText.setBounds(200, 311, 215, 21);
		
		CardCompanyCombo = new Combo(this, SWT.NONE);
		CardCompanyCombo.setItems(new String[] {"Visa", "Mastercard"});
		CardCompanyCombo.setBounds(200, 356, 146, 23);
		
		Label CompanyLabel = new Label(this, SWT.NONE);
		CompanyLabel.setText("Credit Card Company:");
		CompanyLabel.setBounds(76, 359, 118, 15);
		
		Label NumberLabel = new Label(this, SWT.NONE);
		NumberLabel.setText("Credit Card Number:");
		NumberLabel.setBounds(84, 314, 110, 15);
		
		Link ReturnLink = new Link(this, SWT.NONE);
		ReturnLink.setBounds(10, 10, 79, 15);
		ReturnLink.setText("<a>Return to login</a>");
		ReturnLink.addSelectionListener(new SelectionAdapter () {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Return();
			}
		});
		
		passwordMatchError = new Label(this, SWT.WRAP);
		passwordMatchError.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		passwordMatchError.setBounds(385, 216, 79, 31);
		passwordMatchError.setText("Passwords do not match!");
		passwordMatchError.setVisible(false);
		
		usernameExistsError = new Label(this, SWT.WRAP);
		usernameExistsError.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		usernameExistsError.setBounds(385, 110, 145, 31);
		usernameExistsError.setText("An account with this username already exists!");
		usernameExistsError.setVisible(false);
		
		Label PasswordStrenghLabel = new Label(this, SWT.NONE);
		PasswordStrenghLabel.setText("Password Strengh:");
		PasswordStrenghLabel.setBounds(385, 163, 97, 15);
		
		passwordStrengh = new Label(this, SWT.NONE);
		passwordStrengh.setBounds(485, 163, 55, 15);
		passwordStrengh.setText("Medium\r\n");
		passwordStrengh.setVisible(false);
		
		invalidUsernameError = new Label(this, SWT.WRAP);
		invalidUsernameError.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		invalidUsernameError.setBounds(385, 102, 146, 46);
		invalidUsernameError.setText("This username is invalid! it should contain up to 8 letters or numbers");
		invalidUsernameError.setVisible(false);
		
		Label PasswordDetailsLabel = new Label(this, SWT.WRAP);
		PasswordDetailsLabel.setBounds(200, 184, 330, 31);
		PasswordDetailsLabel.setText("Your password should contain at least one lowercase letter and one number, and should be between 6-12 characters long!");
		
		emailExistsError = new Label(this, SWT.WRAP);
		emailExistsError.setText("An account with this email adress already exists!");
		emailExistsError.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		emailExistsError.setBounds(385, 261, 145, 31);
		emailExistsError.setVisible(false);
		
		invalidEmailError = new Label(this, SWT.WRAP);
		invalidEmailError.setText("This email adress is invalid!");
		invalidEmailError.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		invalidEmailError.setBounds(384, 269, 146, 15);
		invalidEmailError.setVisible(false);
		
		invalidCardError  = new Label(this, SWT.WRAP);
		invalidCardError.setText("Invalid card number");
		invalidCardError.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		invalidCardError.setBounds(421, 306, 87, 31);
		invalidCardError.setVisible(false);

	}

	private void Return() {
		parent.setSize(origin.getSize());
		origin.setVisible(true);
		dispose();
		parent.pack();
	}
	
	private void CheckUsernameValidity(){
		try {
			if(UsernameText.getText().equals("")) {
				UsernameText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			} else {
				origin.LoginSystem.isUsernameValid(UsernameText.getText());
				UsernameText.setBackground(SWTResourceManager.getColor(152, 251, 152));
			}
			invalidUsernameError.setVisible(false);
			usernameExistsError.setVisible(false);
		} catch (IllegalUsernameException e) {
			UsernameText.setBackground(SWTResourceManager.getColor(255, 218, 186));
			invalidUsernameError.setVisible(true);
			usernameExistsError.setVisible(false);
		} catch (UsernameAlreadyExistsException e) {
			UsernameText.setBackground(SWTResourceManager.getColor(255, 218, 186));
			invalidUsernameError.setVisible(false);
			usernameExistsError.setVisible(true);
		}
	}
	
	private void CheckPasswordsMatch() {
		CheckPasswordStrengh();
		if(!PasswordText.getText().equals(PasswordText2.getText())){
			passwordMatchError.setVisible(true);
			PasswordText2.setBackground(SWTResourceManager.getColor(255, 218, 186));
			
		} else {
			passwordMatchError.setVisible(false);
			if(PasswordText2.getText().equals("")) {
				PasswordText2.setBackground(SWTResourceManager.getColor(255,255,255));
			} else {
				PasswordText2.setBackground(SWTResourceManager.getColor(152, 251, 152));
			}
		}
	}
	
	private void CheckPasswordStrengh() {
		int strength = origin.LoginSystem.checkPasswordStrengh(PasswordText.getText());
		passwordStrengh.setVisible(!PasswordText.getText().equals(""));
		if(PasswordText.getText().equals("")){
			PasswordText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			return;
		}
		switch(strength) {
		case 2:
			passwordStrengh.setText("Medium");
			passwordStrengh.setForeground(SWTResourceManager.getColor(255, 215, 0));
			PasswordText.setBackground(SWTResourceManager.getColor(152, 251, 152));
			break;
		case 3:
			passwordStrengh.setText("High");
			passwordStrengh.setForeground(SWTResourceManager.getColor(0, 128, 0));
			PasswordText.setBackground(SWTResourceManager.getColor(152, 251, 152));
			break;

		default:
			passwordStrengh.setText("Low");
			passwordStrengh.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
			PasswordText.setBackground(SWTResourceManager.getColor(255, 218, 186));
			break;

		}
	}
	
	private void CheckEmailValidity() {
		try {
			if(EmailText.getText().equals("")) {
				EmailText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			} else {
				origin.LoginSystem.isEmailValid(EmailText.getText());
				EmailText.setBackground(SWTResourceManager.getColor(152, 251, 152));
			}
			invalidEmailError.setVisible(false);
			emailExistsError.setVisible(false);
		} catch (IllegalEmailException e) {
			EmailText.setBackground(SWTResourceManager.getColor(255, 218, 186));
			invalidEmailError.setVisible(true);
			emailExistsError.setVisible(false);
		} catch (EmailAlreadyExistsException e) {
			EmailText.setBackground(SWTResourceManager.getColor(255, 218, 186));
			invalidEmailError.setVisible(false);
			emailExistsError.setVisible(true);
		}
	}
	
	private void CheckCreditCardValidity() {
		try {
			if(CardNumberText.getText().equals("")) {
				CardNumberText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			} else {
				origin.LoginSystem.CheckCreditCardDetails(CardNumberText.getText(), CardCompanyCombo.getText());
				CardNumberText.setBackground(SWTResourceManager.getColor(152, 251, 152));
			}
			invalidCardError.setVisible(false);
		} catch (InvalidCardNumberException e) {
			CardNumberText.setBackground(SWTResourceManager.getColor(255, 218, 186));
			invalidCardError.setVisible(true);
		} 
	}
	
	private void Register() {
		CheckUsernameValidity();
		CheckPasswordsMatch();
		CheckPasswordStrengh();
		CheckEmailValidity();
		CheckCreditCardValidity();
		if(isOk(UsernameText) && isOk(PasswordText) && isOk(PasswordText2) && isOk(EmailText) && isOk(CardNumberText)) {
			origin.LoginSystem.RegisterUser(UsernameText.getText(), PasswordText.getText(), EmailText.getText(), CardNumberText.getText(), CardCompanyCombo.getText());
			Return();
		}
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private boolean isOk(Text t){
		return t.getBackground().equals(SWTResourceManager.getColor(152, 251, 152));
	}
	
}
