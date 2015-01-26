package eShop;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

@SuppressWarnings("serial")
public interface IShoppingCart { //change


	
	
	
	class CartException extends RuntimeException {}
	class Sale {
		public int item1_barcode;
		public int item1_amount;
		public int item2_barcode;
		public int item2_amount;
		
		Sale(int i1b, int i1a, int i2b, int i2a) {
			item1_barcode = i1b;
			item1_amount = i1a;
			item2_barcode = i2b;
			item2_amount = i2a;
		}
	}
	
	
	//keep an array list of items or something, I think you can cast array to array-list?
	//i suggest you make some aux methods for this, as this list will be used a lot.
	//return a reference to the list of items. I need to alter the items dynamically (yay for you?)
	ArrayList<Item> getItemList();
	
	//add given item to item list. if item with barcode already exists in list, add the amounts.
	void addToCart(Item item) throws CartException;
	//remove item with given barcode from list. there can be items with same barcode, one free one not.
	void removeFromCart(int barcode, boolean isFree) throws CartException;
	
	Item getItem(int barcode);
	
	//check if best by date hasn't passed.
	boolean checkIfStillOk(int barcode) throws CartException;
	
	//return the discount for the item (if it has 0 discount, then return 0 don't throw an exception)
	int getDiscount(int barcode) throws CartException;
	
	//check if there is a sale with given barcode. if no, return null.
	Sale getSaleWithBarcode(int barcode);
	
	//just iterate over the list and add the prices
	Double calculateTotalPriceInCart();
	
	void sendToShipment();
	
	void payForCart();
	
	
	
}
