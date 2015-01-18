package eShop;

import java.sql.*;

public interface IShoppingCart {
	
	class ShoppingCartException extends Exception {}
	class NoSaleExcepion extends ShoppingCartException {}
	
	class Sale {
		int saleItemBarcode;
		int saleItemAmount;
		int freeItemBarcode;
		int freeItemAmount;
	}
		
	//can either add or update
	void addToCart(int barcode, int amount);
	void removeFromCart(int barcode, int amount);
	//check if best by date hasn't passed.
	boolean checkIfStillOk(int barcode);
	
	int getDiscount(int barcode);
	
	Sale getSales(int barcode) throws NoSaleExcepion;
	
	
	
	

}
