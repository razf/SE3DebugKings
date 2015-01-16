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
		shell.setSize(600,400);
		shell.open();
		ILoginSystem ls = new DummyLoginSystem();
		LoginForm l = new LoginForm(shell, SWT.NONE, ls);
		
		shell.setSize(l.getSize());
		shell.pack();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
	}

}
