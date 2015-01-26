package eShop;

import java.util.Calendar;

public class Item {
	public String name;
	public int barcode;
	public double price;
	public int amount;
	public Calendar date;
	public boolean isFree;
	
	public Item(String name, int barcode, double price, int amount, Calendar date, boolean isFree){
		this.name = name;
		this.barcode = barcode;
		this.price = price;
		this.amount = amount;
		this.date = date;
		this.isFree = isFree;
	}
}