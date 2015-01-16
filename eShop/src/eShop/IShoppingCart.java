package eShop;


public interface IShoppingCart {

	class CartException extends RuntimeException {}
	
	void addToCart(int barcode, int amount) throws CartException;

}
