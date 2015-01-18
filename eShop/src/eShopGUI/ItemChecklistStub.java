package eShopGUI;

import java.text.DecimalFormat;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;

public class ItemChecklistStub extends Composite {

	CartDisplay Cart;
	Composite parent;
	Double price;
	CartDisplay.Item item;
	boolean hasDiscount;
	Label priceLabel;
	boolean isFree;
	DecimalFormat numberFormat;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ItemChecklistStub(Composite parent, int style, CartDisplay Cart , CartDisplay.Item item, boolean hasDiscount, boolean isFree) {
		super(parent, SWT.NONE);
		this.parent = parent;
		
		numberFormat = new DecimalFormat("#.00");
		this.Cart = Cart;
		price = item.amount * item.price;
		this.hasDiscount = hasDiscount;
		this.isFree = isFree;
		this.item = item;
		
		Composite background = new Composite(this, SWT.NONE);
		background.setBounds(0, 0, 225, 46);
		
		Label ItemNameLabel = new Label(background, SWT.NONE);
		ItemNameLabel.setLocation(10, 10);
		ItemNameLabel.setSize(104, 15);
		ItemNameLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		ItemNameLabel.setText(item.name);
		
		Spinner QuantitySpinner = new Spinner(background, SWT.BORDER);
		QuantitySpinner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				updateAmount(QuantitySpinner.getSelection());
			}
			@Override
			public void mouseDown(MouseEvent e) {
				updateAmount(QuantitySpinner.getSelection());
			}
		});
		QuantitySpinner.setLocation(116, 12);
		QuantitySpinner.setSize(47, 22);
		QuantitySpinner.setMinimum(1);
		QuantitySpinner.setSelection(item.amount);
		
		CLabel RemoveItem = new CLabel(background, SWT.NONE);
		RemoveItem.setLocation(178, 10);
		RemoveItem.setSize(37, 28);
		RemoveItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				RemoveFromCart();
			}
		});
		RemoveItem.setImage(SWTResourceManager.getImage(ItemChecklistStub.class, "/com/sun/java/swing/plaf/windows/icons/Error.gif"));
		RemoveItem.setText("");
		
		priceLabel = new Label(background, SWT.NONE);
		priceLabel.setLocation(10, 25);
		priceLabel.setSize(55, 15);
		priceLabel.setText(numberFormat.format(price).toString()+"¤");
		if(hasDiscount){
			priceLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		}
		
		if(isFree){
			Color freeColor = SWTResourceManager.getColor(152, 251, 152);
			background.setBackground(freeColor);
			QuantitySpinner.setEnabled(false);
			priceLabel.setBackground(freeColor);
			ItemNameLabel.setBackground(freeColor);
			RemoveItem.setBackground(freeColor);
			
		}

	}

	protected void RemoveFromCart() {
//		Cart.RemoveFromCart();
		dispose();
		parent.layout();
			parent.pack();
	}
	
	protected void updateAmount(int amount) {
		item.amount = amount;
		price = item.amount*item.price;
		priceLabel.setText(numberFormat.format(price).toString()+"¤");
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
