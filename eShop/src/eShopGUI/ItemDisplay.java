package eShopGUI;

import java.util.Date;

import javax.xml.crypto.Data;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

import eShop.IShoppingCart;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.custom.CLabel;

public class ItemDisplay extends Composite {
	
	CartDisplay Cart;
	int barcode;
	Double discount;
	Spinner quantitySpinner;
	Date best_by;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ItemDisplay(Composite parent, int style, int barcode, String name, String price, double discount, Date best_by) {
		super(parent, style);
		
		this.barcode = barcode;
		this.discount = discount;
		
		Label ItemImage = new Label(this, SWT.NONE);
		ItemImage.setImage(SWTResourceManager.getImage("Images\\Milk.png"));
		ItemImage.setBounds(15, 10, 100, 105);
		
		Button BuyButton = new Button(this, SWT.WRAP);
		BuyButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddToCart(barcode,quantitySpinner.getDigits());
			}
		});
		BuyButton.setSelection(true);
		BuyButton.setBounds(10, 232, 66, 38);
		BuyButton.setText("Add To Cart");
		
		Label ItemNameLabel = new Label(this, SWT.WRAP);
		ItemNameLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		ItemNameLabel.setAlignment(SWT.CENTER);
		ItemNameLabel.setBounds(15, 121, 100, 38);
		ItemNameLabel.setText(name);
		
		Label PriceLabel = new Label(this, SWT.NONE);
		PriceLabel.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		PriceLabel.setAlignment(SWT.CENTER);
		PriceLabel.setBounds(15, 183, 100, 27);
		PriceLabel.setText(price+"¤");
		
		Label DiscountLabel = new Label(this, SWT.NONE);
		DiscountLabel.setAlignment(SWT.CENTER);
		DiscountLabel.setBounds(15, 211, 100, 15);
		DiscountLabel.setText(this.discount.intValue()+"% off!");
		if(discount == 0){
			DiscountLabel.setVisible(false);
		} else {
			PriceLabel.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
			Double new_price = Double.parseDouble(price)-(Double.parseDouble(price)*(discount/100));
			PriceLabel.setText(new_price.toString()+"¤");
			PriceLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
			DiscountLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		}
		
		quantitySpinner = new Spinner(this, SWT.BORDER);
		quantitySpinner.setMaximum(99);
		quantitySpinner.setMinimum(1);
		quantitySpinner.setBounds(82, 241, 39, 22);
		
		Label BestByLabel = new Label(this, SWT.NONE);
		BestByLabel.setBounds(15, 165, 100, 15);
		BestByLabel.setText("Best by:");
		
	}

	private void AddToCart(int barcode, int amount) {
		Cart.addToCart(barcode, amount);
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
