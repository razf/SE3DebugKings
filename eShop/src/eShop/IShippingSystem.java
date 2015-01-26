package eShop;

import java.util.ArrayList;

public interface IShippingSystem {

	class ShippingBox{
		//not sure what to put here, up to you
	}
	
	//should also contain the same list of items from the cart
	//also I recommend a list of boxes
	void addToBox(ShippingBox box, Item i);
	
	//note - lets say we have 2 milks - we can remove the item milk with amount = 1, and put it in another box
	void removeFromBox(ShippingBox box, Item i);
	
	void addToOpen(Item i);
	
	void removeFromOpen(Item i);
	/*
	 * we want to give the user the ability to go back to the shopping screen with his items.
	 * when/if he comes back from there, we will give the new list of items.
	 * need to iterate over the items in and out of boxes, if new items added add them to 
	 * items outside of boxes (never to box), and if items in boxes are removed (first remove from outside if possible)
	 * then remove them from the boxes.
	 */
	void updateWithNewItemList(ArrayList<Item> updatedItems);
	
	void autoFillBoxes();
	
	void Ship(String city, String street, String number);

	void getFirstAvailableBox();
	
	
}
