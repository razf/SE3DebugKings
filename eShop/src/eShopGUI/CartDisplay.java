package eShopGUI;

import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Link;

public class CartDisplay extends Composite {
	class Item {
		public String name;
		public double price;
		public int amount;
		
		public Item(String name, double price, int amount){
			this.name = name;
			this.price = price;
			this.amount = amount;
		}
	}
	ArrayList<Item> CartItems;
	Composite ChecklistComposite;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CartDisplay(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
		
		CartItems = new ArrayList<Item>();
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		FormData fd_scrolledComposite = new FormData();
		fd_scrolledComposite.right = new FormAttachment(0, 560);
		fd_scrolledComposite.top = new FormAttachment(0, 10);
		fd_scrolledComposite.left = new FormAttachment(0, 10);
		fd_scrolledComposite.bottom = new FormAttachment(0, 590);
		scrolledComposite.setLayoutData(fd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		GridLayout gl_composite = new GridLayout(4, true);
		gl_composite.horizontalSpacing = 10;
		composite.setLayout(gl_composite);
		
		ItemDisplay item1Display = new ItemDisplay(composite, SWT.NONE, 1, "Milk", "10", 10, new Date());
		ItemDisplay item2Display = new ItemDisplay(composite, SWT.NONE, 1, "Milk", "10", 10, new Date());
		ItemDisplay item3Display = new ItemDisplay(composite, SWT.NONE, 1, "Milk", "10", 10, new Date());
		ItemDisplay item4Display = new ItemDisplay(composite, SWT.NONE, 1, "Milk", "10", 10, new Date());
		ItemDisplay item5Display = new ItemDisplay(composite, SWT.NONE, 1, "Milk", "10", 10, new Date());
		ItemDisplay item6Display = new ItemDisplay(composite, SWT.NONE, 1, "Milk", "10", 10, new Date());
		ItemDisplay item7Display = new ItemDisplay(composite, SWT.NONE, 1, "Milk", "10", 10, new Date());
		ItemDisplay item8Display = new ItemDisplay(composite, SWT.NONE, 1, "Milk", "10", 10, new Date());
		ItemDisplay item9Display = new ItemDisplay(composite, SWT.NONE, 1, "SUPRISE", "10", 10, new Date());
		ItemDisplay item10Display = new ItemDisplay(composite, SWT.NONE, 1, "SUPRISE", "10", 10, new Date());
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		ScrolledComposite scrolledComposite_1 = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		FormData fd_scrolledComposite_1 = new FormData();
		fd_scrolledComposite_1.bottom = new FormAttachment(scrolledComposite, 273);
		fd_scrolledComposite_1.left = new FormAttachment(scrolledComposite, 6);
		fd_scrolledComposite_1.top = new FormAttachment(scrolledComposite, 0, SWT.TOP);
		fd_scrolledComposite_1.right = new FormAttachment(100, -10);
		scrolledComposite_1.setLayoutData(fd_scrolledComposite_1);
		scrolledComposite_1.setExpandHorizontal(true);
		scrolledComposite_1.setExpandVertical(true);
		
		Composite ChecklistComposite = new Composite(scrolledComposite_1, SWT.NONE);
		ChecklistComposite.setLayout(new GridLayout(1, true));
		ItemChecklistStub ICS1 = new ItemChecklistStub(ChecklistComposite, SWT.NONE,this, new Item("Milk", 10.0, 2),false, false);
		ItemChecklistStub ICS2 = new ItemChecklistStub(ChecklistComposite, SWT.NONE,this, new Item("Bread", 6, 1), true, false);
		ItemChecklistStub ICS3 = new ItemChecklistStub(ChecklistComposite, SWT.NONE,this, new Item("Water", 12, 1),false, false);
		ItemChecklistStub ICS4 = new ItemChecklistStub(ChecklistComposite, SWT.NONE,this, new Item("Yogurt", 3.2, 4),true, false);
		ItemChecklistStub ICS5 = new ItemChecklistStub(ChecklistComposite, SWT.NONE,this, new Item("Cucumbers (400g)", 5, 1),false, false);
		ItemChecklistStub ICS6 = new ItemChecklistStub(ChecklistComposite, SWT.NONE,this, new Item("Potatoes (1.5kilo)", 14, 1),false, false);
		ItemChecklistStub ICS7 = new ItemChecklistStub(ChecklistComposite, SWT.NONE,this, new Item("Tuna", 10.0, 4),false, true);
		scrolledComposite_1.setContent(ChecklistComposite);
		scrolledComposite_1.setMinSize(ChecklistComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		FormData fd_composite_1 = new FormData();
		fd_composite_1.bottom = new FormAttachment(scrolledComposite_1, 70, SWT.BOTTOM);
		fd_composite_1.right = new FormAttachment(scrolledComposite, 265, SWT.RIGHT);
		fd_composite_1.top = new FormAttachment(scrolledComposite_1, 6);
		fd_composite_1.left = new FormAttachment(scrolledComposite, 6);
		composite_1.setLayoutData(fd_composite_1);
		
		Label TotalPriceLabel = new Label(composite_1, SWT.NONE);
		TotalPriceLabel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		TotalPriceLabel.setBounds(27, 17, 110, 29);
		TotalPriceLabel.setText("Total Price:");
		
		Label PriceLabel = new Label(composite_1, SWT.NONE);
		PriceLabel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		PriceLabel.setBounds(143, 17, 106, 29);
		PriceLabel.setText("P");
		
		Button CheckoutButton = new Button(this, SWT.NONE);
		CheckoutButton.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		FormData fd_CheckoutButton = new FormData();
		fd_CheckoutButton.top = new FormAttachment(composite_1, 25);
		fd_CheckoutButton.left = new FormAttachment(scrolledComposite, 57);
		fd_CheckoutButton.bottom = new FormAttachment(100, -158);
		fd_CheckoutButton.right = new FormAttachment(100, -59);
		CheckoutButton.setLayoutData(fd_CheckoutButton);
		CheckoutButton.setText("Checkout");
		
		Button DeliveryButton = new Button(this, SWT.NONE);
		DeliveryButton.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		FormData fd_DeliveryButton = new FormData();
		fd_DeliveryButton.bottom = new FormAttachment(CheckoutButton, 90, SWT.BOTTOM);
		fd_DeliveryButton.top = new FormAttachment(CheckoutButton, 26);
		fd_DeliveryButton.left = new FormAttachment(scrolledComposite, 57);
		fd_DeliveryButton.right = new FormAttachment(CheckoutButton, 0, SWT.RIGHT);
		DeliveryButton.setLayoutData(fd_DeliveryButton);
		DeliveryButton.setText("Delivery");
		
		Link LeaveLink = new Link(this, SWT.NONE);
		FormData fd_LeaveLink = new FormData();
		fd_LeaveLink.bottom = new FormAttachment(100, -10);
		fd_LeaveLink.right = new FormAttachment(100, -10);
		LeaveLink.setLayoutData(fd_LeaveLink);
		LeaveLink.setText("<a>Exit eShop</a>");


		
		
		

		
		

	}
	

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}


	public void addToCart(int barcode, int amount) {
		// TODO Auto-generated method stub
		CartItems.index
	}


	public void RemoveFromCart() {
		// TODO Auto-generated method stub
		
	}
}
