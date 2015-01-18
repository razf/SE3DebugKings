package eShopGUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import eShop.DummyLoginSystem;
import eShop.ILoginSystem;

public class GuiTexting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(800,600);
		shell.open();
		ILoginSystem ls = new DummyLoginSystem();
//		LoginForm l = new LoginForm(shell, SWT.NONE, ls);
		
		CartDisplay c = new CartDisplay(shell, SWT.NONE);
		

		shell.pack();

		c.pack();
		shell.setSize(850,650);

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
	}

}
