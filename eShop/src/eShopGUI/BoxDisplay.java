package eShopGUI;

import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

import eShopGUI.ShippingDisplay.stubInfo;
public class BoxDisplay extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public BoxDisplay(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		setLayout(new FormLayout());
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(0, 180);
		fd_composite.right = new FormAttachment(0, 190);
		fd_composite.top = new FormAttachment(0);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new GridLayout(3, false));
		DropTargetListener listener = new DropTargetListener() {
			
			@Override
			public void dropAccept(org.eclipse.swt.dnd.DropTargetEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drop(org.eclipse.swt.dnd.DropTargetEvent arg0) {
				System.out.println("wee!");
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dragOver(org.eclipse.swt.dnd.DropTargetEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dragOperationChanged(org.eclipse.swt.dnd.DropTargetEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dragLeave(org.eclipse.swt.dnd.DropTargetEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dragEnter(org.eclipse.swt.dnd.DropTargetEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		};

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void removeItem(stubInfo info) {
		// TODO Auto-generated method stub
		
	}

}
