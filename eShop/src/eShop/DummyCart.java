package eShop;

import java.util.ArrayList;

public class DummyCart implements IShoppingCart {

	@Override
	public ArrayList<Item> getItemList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addToCart(Item item) throws CartException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFromCart(int barcode, boolean isFree)
			throws CartException {
		// TODO Auto-generated method stub

	}

	@Override
	public Item getItem(int barcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkIfStillOk(int barcode) throws CartException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getDiscount(int barcode) throws CartException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Sale getSaleWithBarcode(int barcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calculateTotalPriceInCart() {
		// TODO Auto-generated method stub
		return new Double(3);
	}

	@Override
	public void sendToShipment() {
		// TODO Auto-generated method stub

	}

	@Override
	public void payForCart() {
		// TODO Auto-generated method stub

	}

}
