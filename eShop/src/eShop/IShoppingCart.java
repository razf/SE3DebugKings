package eShop;

import java.sql.*;

public interface IShoppingCart {

	class CartException extends RuntimeException {}
	
	//can either add or update
	void addToCart(int barcode, int amount);
	void removeFromCart(int barcode, int amount);
	//check if best by date hasn't passed.
	boolean checkIfStillOk(int barcode);
	
	int getDiscount(int barcode);
	
	

}
