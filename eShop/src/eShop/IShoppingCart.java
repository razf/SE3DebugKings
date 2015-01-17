package eShop;

import java.sql.*;

@SuppressWarnings("serial")
public interface IShoppingCart {

	class CartException extends RuntimeException {}
	
	//can either add or update
	void addToCart(int barcode, int amount) throws CartException;
	void removeFromCart(int barcode, int amount) throws CartException;
	//check if best by date hasn't passed.
	boolean checkIfStillOk(int barcode) throws CartException;
	
	int getDiscount(int barcode)throws CartException;
	
	

}
