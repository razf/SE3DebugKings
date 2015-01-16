package eShopGUI;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;

public class AddCreditCardForm extends Composite {
	private Text CreditCardNumberText;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public AddCreditCardForm(Composite parent, int style) {
		super(parent, style);
		
		Button SubmitButton = new Button(this, SWT.NONE);
		SubmitButton.setText("Submit");
		SubmitButton.setBounds(222, 229, 105, 46);
		
		Label TitleLabel = new Label(this, SWT.NONE);
		TitleLabel.setText("eShop");
		TitleLabel.setFont(SWTResourceManager.getFont("Segoe UI", 48, SWT.NORMAL));
		TitleLabel.setBounds(185, 0, 179, 86);
		
		CreditCardNumberText = new Text(this, SWT.BORDER);
		CreditCardNumberText.setBounds(197, 119, 203, 21);
		
		Combo ChooseCompanyCombo = new Combo(this, SWT.NONE);
		ChooseCompanyCombo.setItems(new String[] {"Visa", "Mastercard"});
		ChooseCompanyCombo.setBounds(197, 177, 146, 23);
		
		Label CreditCardNumberLabel = new Label(this, SWT.NONE);
		CreditCardNumberLabel.setBounds(70, 122, 121, 15);
		CreditCardNumberLabel.setText("Credit Card Number:");
		
		Label CreditCardCompanyLabel = new Label(this, SWT.NONE);
		CreditCardCompanyLabel.setBounds(70, 180, 131, 15);
		CreditCardCompanyLabel.setText("Credit Card Company:");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
