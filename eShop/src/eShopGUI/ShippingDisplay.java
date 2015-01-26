package eShopGUI;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

import eShop.IShippingSystem;
import eShop.Item;
import eShopGUI.ShippingDisplay.stubInfo;

import org.eclipse.swt.widgets.Label;
public class ShippingDisplay extends Composite {
	
	IShippingSystem shippingSystem;
	class stubInfo{
		public String name;
		public Integer amount;
		
		public stubInfo(String stub_name, int stub_amount) {
			name = stub_name;
			amount = stub_amount;
		}
		
	}
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ShippingDisplay(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.V_SCROLL);
		FormData fd_scrolledComposite = new FormData();
		fd_scrolledComposite.left = new FormAttachment(0, 10);
		fd_scrolledComposite.top = new FormAttachment(0, 10);
		fd_scrolledComposite.bottom = new FormAttachment(0, 590);
		scrolledComposite.setLayoutData(fd_scrolledComposite);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setExpandHorizontal(true);
		
		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new GridLayout(1, true));
		
		ItemShippingStub itemShippingStub = new ItemShippingStub(composite, SWT.NONE, new stubInfo("Milk",2), this,null);
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrolledComposite.setMinSize(new Point(433, 145));
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		fd_scrolledComposite.right = new FormAttachment(100, -634);
		GridLayout gl_composite_1 = new GridLayout(3, false);
		composite_1.setLayout(gl_composite_1);
		FormData fd_composite_1 = new FormData();
		fd_composite_1.left = new FormAttachment(scrolledComposite, 64);
		fd_composite_1.right = new FormAttachment(100, -10);
		fd_composite_1.bottom = new FormAttachment(0, 590);
		fd_composite_1.top = new FormAttachment(0, 10);
		composite_1.setLayoutData(fd_composite_1);
		
		BoxDisplay b1 = new BoxDisplay(composite_1, SWT.NONE);
		BoxDisplay b2 = new BoxDisplay(composite_1, SWT.NONE);
		BoxDisplay b3 = new BoxDisplay(composite_1, SWT.NONE);
		BoxDisplay b4 = new BoxDisplay(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);


	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void RemoveFromBox(stubInfo info) {
		// TODO Auto-generated method stub
		
	}

	public void AddToBox(stubInfo info) {
		// TODO Auto-generated method stub
		
	}
	
	public BoxDisplay getFirstAvailableBox() {
		shippingSystem.getFirstAvailableBox();
		return null;
	}
}
