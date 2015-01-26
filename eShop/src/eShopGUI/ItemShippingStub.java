package eShopGUI;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import eShopGUI.ShippingDisplay.stubInfo;

public class ItemShippingStub extends Composite {

	public boolean inBox;
	public ShippingDisplay.stubInfo info;
	ShippingDisplay shipment;
	BoxDisplay box;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ItemShippingStub(Composite parent, int style, stubInfo info, ShippingDisplay shipment, BoxDisplay box) {
		super(parent, style);
			
		this.shipment = shipment;
		this.info = info;
		inBox = false;
		this.box = box;
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 0, 180, 30);
		
		Label ItemNameLabel = new Label(composite, SWT.NONE);
		ItemNameLabel.setBounds(10, 7, 88, 15);
		ItemNameLabel.setText(info.name);
				
		Label amountLabel = new Label(composite, SWT.NONE);
		amountLabel.setBounds(110, 7, 18, 15);
		amountLabel.setText(info.amount.toString());
		
		Label ActionLabel = new Label(composite, SWT.NONE);
		ActionLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(inBox) {
					shipment.RemoveFromBox(info);
					box.removeItem(info);
				} else {
					shipment.AddToBox(info);
				}
			}
		});
		ActionLabel.setImage(SWTResourceManager.getImage(ItemShippingStub.class, "/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png"));
		ActionLabel.setBounds(143, 7, 27, 15);


	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
