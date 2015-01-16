package eShopGUI;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class RecoverDetailsForm extends Composite {
	private Text text;
	private Text text_1;
	private boolean withUsername;
	private LoginForm origin;
	private Composite parent;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public RecoverDetailsForm(Composite parent, int style, LoginForm origin) {
		super(parent, style);
		
		this.origin = origin;
		this.parent = parent;
		Label label = new Label(this, SWT.NONE);
		label.setText("eShop");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 48, SWT.NORMAL));
		label.setBounds(160, 0, 179, 86);
		
		Label InfoLabel = new Label(this, SWT.NONE);
		InfoLabel.setBounds(49, 92, 401, 15);
		InfoLabel.setText("Please insert your Username and Email, so we can recover your password:");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(194, 126, 179, 21);
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(194, 162, 179, 21);
		
		Label UsernameLabel = new Label(this, SWT.NONE);
		UsernameLabel.setBounds(133, 129, 55, 15);
		UsernameLabel.setText("Username:");
		
		Label EmailLabel = new Label(this, SWT.NONE);
		EmailLabel.setBounds(133, 165, 55, 15);
		EmailLabel.setText("Email:");
		
		Button RecoverButton = new Button(this, SWT.NONE);
		RecoverButton.setBounds(191, 235, 118, 36);
		RecoverButton.setText("Reset Password");
		
		Link NoUsernameLink = new Link(this, SWT.NONE);
		NoUsernameLink.setBounds(170, 203, 169, 15);
		NoUsernameLink.setText("<a>I don't remember my username</a>");
		
		Link ReturnLabel = new Link(this, 0);
		ReturnLabel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Return();
			}
		});
		ReturnLabel.setText("<a>Return to login</a>");
		ReturnLabel.setBounds(10, 10, 79, 15);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private void Return() {		
		parent.setSize(origin.getSize());
		origin.setVisible(true);
		dispose();
		parent.pack();
	}
}
