package eShopGUI;

import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.win32.TCHAR;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Link;













import eShop.DummyCart;
import eShop.IShoppingCart;
import eShop.Item;
import eShop.IShoppingCart.Sale;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEffect;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;

public class CartDisplay extends Composite {
	
	IShoppingCart Cart;
	ArrayList<Item> CartItems;
	Composite ChecklistComposite;
	Label priceLabel;
	
	ArrayList<ItemChecklistStub> cartStubs;
	
	Label saleLabel;
	Label buyLabel;
	Label getLabel;
	Label freeLabel;
	Button dealButton;
	SelectionListener saleListener;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CartDisplay(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
		
		Cart = new DummyCart();
		CartItems = new ArrayList<Item>();
		cartStubs = new ArrayList<ItemChecklistStub>();
		
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
		
		Calendar cal = new Calendar() {
			
			@Override
			public void roll(int field, boolean up) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int getMinimum(int field) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getMaximum(int field) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getLeastMaximum(int field) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getGreatestMinimum(int field) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			protected void computeTime() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			protected void computeFields() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void add(int field, int amount) {
				// TODO Auto-generated method stub
				
			}
		};

		
		ItemDisplay item1Display = new ItemDisplay(composite, SWT.NONE, this, 1, "Milk", "10", 10, cal);
//		ItemDisplay item2Display = new ItemDisplay(composite, SWT.NONE, this,1, "Milk", "10", 10, cal);
//		ItemDisplay item3Display = new ItemDisplay(composite, SWT.NONE, this,1, "Milk", "10", 10, cal);
//		ItemDisplay item4Display = new ItemDisplay(composite, SWT.NONE, this, 1, "Milk", "10", 10, cal);
//		ItemDisplay item5Display = new ItemDisplay(composite, SWT.NONE, this, 1, "Milk", "10", 10, cal);
//		ItemDisplay item6Display = new ItemDisplay(composite, SWT.NONE, this,1, "Milk", "10", 10, cal);
//		ItemDisplay item7Display = new ItemDisplay(composite, SWT.NONE,this,  1, "Milk", "10", 10, cal);
//		ItemDisplay item8Display = new ItemDisplay(composite, SWT.NONE, this, 1, "Milk", "10", 10, cal);
//		ItemDisplay item9Display = new ItemDisplay(composite, SWT.NONE, this, 1, "SUPRISE", "10", 10, cal);
//		ItemDisplay item10Display = new ItemDisplay(composite, SWT.NONE, this, 1, "SUPRISE", "10", 10, cal);
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
		
		ChecklistComposite = new Composite(scrolledComposite_1, SWT.NONE);
		ChecklistComposite.setLayout(new GridLayout(1, true));
		ItemChecklistStub ICS1 = new ItemChecklistStub(ChecklistComposite, SWT.NONE,this, new Item("Milk", 1, 10.0, 2, cal, false), false, false);
		ItemChecklistStub ICS2 = new ItemChecklistStub(ChecklistComposite, SWT.NONE,this, new Item("Bread", 2, 6, 1, cal,false), true, false);
		ItemChecklistStub ICS3 = new ItemChecklistStub(ChecklistComposite, SWT.NONE,this, new Item("Water", 3, 12, 1, cal,false),false, false);
		ItemChecklistStub ICS4 = new ItemChecklistStub(ChecklistComposite, SWT.NONE,this, new Item("Yogurt", 4,3.2, 4, cal,false),true, false);
		ItemChecklistStub ICS5 = new ItemChecklistStub(ChecklistComposite, SWT.NONE,this, new Item("Cucumbers (400g)", 5,5, 1, cal,false),false, false);
		ItemChecklistStub ICS6 = new ItemChecklistStub(ChecklistComposite, SWT.NONE,this, new Item("Potatoes (1.5kilo)", 6,14, 1, cal,false),false, false);
		ItemChecklistStub ICS7 = new ItemChecklistStub(ChecklistComposite, SWT.NONE,this, new Item("Tuna", 7,10.0, 4, cal,false),false, true);
		cartStubs.add(ICS1);
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
		
		
		priceLabel = new Label(composite_1, SWT.NONE);
		priceLabel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		priceLabel.setBounds(143, 17, 106, 29);
		priceLabel.setText("0.0¤");
		
		Link LeaveLink = new Link(this, SWT.NONE);
		FormData fd_LeaveLink = new FormData();
		fd_LeaveLink.bottom = new FormAttachment(100, -10);
		fd_LeaveLink.right = new FormAttachment(100, -10);
		LeaveLink.setLayoutData(fd_LeaveLink);
		LeaveLink.setText("<a>Exit eShop</a>");
		
		saleLabel = new Label(this, SWT.NONE);
		saleLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		FormData fd_saleLabel = new FormData();
		fd_saleLabel.left = new FormAttachment(scrolledComposite, 75);
		fd_saleLabel.right = new FormAttachment(100, -82);
		saleLabel.setLayoutData(fd_saleLabel);
		saleLabel.setText("We have a sale!");
		
		buyLabel = new Label(this, SWT.CENTER);
		fd_saleLabel.bottom = new FormAttachment(buyLabel, -6);
		buyLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		FormData fd_buyLabel = new FormData();
		fd_buyLabel.top = new FormAttachment(0, 386);
		fd_buyLabel.right = new FormAttachment(scrolledComposite_1, 0, SWT.RIGHT);
		fd_buyLabel.left = new FormAttachment(composite_1, 0, SWT.LEFT);
		
		buyLabel.setLayoutData(fd_buyLabel);
		buyLabel.setText("Buy ");
		
		getLabel = new Label(this, SWT.CENTER);
		getLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		FormData fd_getLabel = new FormData();
		fd_getLabel.right = new FormAttachment(scrolledComposite_1, 0, SWT.RIGHT);
		fd_getLabel.left = new FormAttachment(scrolledComposite, 6);
		getLabel.setLayoutData(fd_getLabel);
		getLabel.setText("Get");
		
		freeLabel = new Label(this, SWT.NONE);
		fd_getLabel.bottom = new FormAttachment(freeLabel, -6);
		freeLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		FormData fd_freeLabel = new FormData();
		fd_freeLabel.top = new FormAttachment(0, 439);
		fd_freeLabel.left = new FormAttachment(scrolledComposite, 115);
		freeLabel.setLayoutData(fd_freeLabel);
		freeLabel.setText("FREE!");
		
		dealButton = new Button(this, SWT.NONE);
		FormData fd_dealButton = new FormData();
		fd_dealButton.top = new FormAttachment(freeLabel, 6);
		fd_dealButton.right = new FormAttachment(scrolledComposite_1, 0, SWT.RIGHT);
		fd_dealButton.left = new FormAttachment(scrolledComposite, 6);
		dealButton.setLayoutData(fd_dealButton);
		dealButton.setText("Click here to get the deal!");
		
		
		
		Button CheckoutButton = new Button(this, SWT.NONE);
		FormData fd_CheckoutButton = new FormData();
		fd_CheckoutButton.bottom = new FormAttachment(dealButton, 60, SWT.BOTTOM);
		fd_CheckoutButton.top = new FormAttachment(dealButton, 6);
		fd_CheckoutButton.right = new FormAttachment(scrolledComposite_1, 0, SWT.RIGHT);
		CheckoutButton.setLayoutData(fd_CheckoutButton);
		CheckoutButton.setText("Checkout and pay");
		
		Button DeliveryButton = new Button(this, SWT.NONE);
		FormData fd_DeliveryButton = new FormData();
		fd_DeliveryButton.bottom = new FormAttachment(dealButton, 60, SWT.BOTTOM);
		fd_DeliveryButton.right = new FormAttachment(scrolledComposite, 114, SWT.RIGHT);
		fd_DeliveryButton.top = new FormAttachment(dealButton, 6);
		fd_DeliveryButton.left = new FormAttachment(scrolledComposite, 6);
		DeliveryButton.setLayoutData(fd_DeliveryButton);
		DeliveryButton.setText("Delivery");
		
		saleLabel.setVisible(false);
		buyLabel.setVisible(false);
		getLabel.setVisible(false);
		freeLabel.setVisible(false);
		dealButton.setVisible(false);



		
		
		

		
		

	}
	

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	
	/**
	 * @param noSale - should sales be offered when adding this item (false for show sales)
	 */
	public ItemChecklistStub addToCart(String name, int barcode, double actual_price ,int amount, Calendar date, boolean isFree, double discount, boolean noSale) {
		Item newItem = new Item(name, barcode, actual_price, amount, date, isFree);
		boolean stillOk = Cart.checkIfStillOk(barcode);
		//if out of date, beep
		if(!stillOk){
			Toolkit.getDefaultToolkit().beep();
		}
		//check if there is a sale to show
		Sale s = Cart.getSaleWithBarcode(barcode);
		if(s != null && !noSale){
			showSale(s, amount, actual_price);
		} 
		
		//check if this item is already in the cart or we're just updating the amount
		ItemChecklistStub ret = null;
		boolean updated = false;
		for(ItemChecklistStub ics : this.cartStubs) {
			if(ics.item.barcode == barcode && ics.isFree == isFree) {
				ics.updateAmount(amount+ics.item.amount);
				updated = true;
				ret = ics;
			}
		}
		if(!updated){
			ItemChecklistStub ICS = new ItemChecklistStub(ChecklistComposite, SWT.NONE, this, newItem, (discount>0), isFree);
			ChecklistComposite.pack();
			cartStubs.add(ICS);
			ret = ICS;
		}
		Cart.addToCart(newItem);
		priceLabel.setText(Cart.calculateTotalPriceInCart().toString());
		return ret;
	}
	
	public void showSale(Sale sale, int amount, double actual_price){
		Item buy = Cart.getItem(sale.item1_barcode);
		Item get = Cart.getItem(sale.item2_barcode);
		buyLabel.setText("Buy "+sale.item1_amount+" "+buy.name);
		getLabel.setText("Get "+sale.item2_amount+" "+get.name);
		saleLabel.setVisible(true);
		buyLabel.setVisible(true);
		getLabel.setVisible(true);
		freeLabel.setVisible(true);
		dealButton.setVisible(true);
		saleListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ItemChecklistStub buyStub = addToCart(buy.name, buy.barcode, buy.price, buy.amount - amount, buy.date, false, 0, true);
				ItemChecklistStub getStub = addToCart(get.name, get.barcode, 0, get.amount, get.date, true, 1, true);
				buyStub.saleStub = getStub;
				buyStub.sale = sale;
				saleLabel.setVisible(false);
				buyLabel.setVisible(false);
				getLabel.setVisible(false);
				freeLabel.setVisible(false);
				dealButton.setVisible(false);
				activateSale();
			}
		};
		dealButton.addSelectionListener(saleListener);

	}
	
	public void activateSale() {
		dealButton.removeSelectionListener(saleListener);
		
	}

	public void removeFromCart(int barcode, boolean isFree) {
		Cart.removeFromCart(barcode, isFree);
		priceLabel.setText(Cart.calculateTotalPriceInCart().toString());
		for(ItemChecklistStub ics : this.cartStubs) {
			if(ics.item.barcode == barcode && ics.isFree == isFree) {
				cartStubs.remove(ics);
				break;
			}
		}


		
	}
	
	public void updateTotalPrice() {
		Double totalPrice = Cart.calculateTotalPriceInCart();
		priceLabel.setText(totalPrice.toString()+"¤");
	}
}
