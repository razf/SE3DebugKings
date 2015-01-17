package eShop;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatabaseFillerAndCreator extends DBManager{
	
	 public Date parseDate(String date) {
		 java.util.Date utilDate = null;
		try {
			utilDate = new SimpleDateFormat("dd/mm/yyyy").parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     return new java.sql.Date(utilDate.getTime());
	  }
	 
	public DatabaseFillerAndCreator(){
		String projectDir = System.getProperty("user.dir", ".");
	    String image_path = projectDir + "\\Images\\milk.png";
	    
		addItemToDb("Milk", 50, parseDate("30/01/2015"), 23.5, image_path);
		addItemToDb("Tomato", 30, parseDate("30/01/2015"), 10.0, image_path);
		addItemToDb("Water", 20, parseDate("1/10/2016"), 15.0, image_path);
		addItemToDb("American Cheese", 60, parseDate("29/01/2015"), 23.5, image_path);
		addItemToDb("Canned Tuna", 17, parseDate("12/03/2022"), 23.5, image_path);
		addItemToDb("Hummus", 95, parseDate("22/09/2015"), 12.0, image_path);
		addItemToDb("White Bread", 110, parseDate("17/02/2015"), 5.0, image_path);
		addItemToDb("Good Wine", 10, parseDate("14/01/2018"), 199.99, image_path);
		addItemToDb("Boxed Wine", 40, parseDate("12/04/2019"), 23.5, image_path);
		addItemToDb("Eggs", 37, parseDate("17/03/2015"), 12.5, image_path);
		addItemToDb("Hot Pastrame", 20, parseDate("01/02/2015"), 40.0, image_path);
		addItemToDb("Belgian Chocolate", 5, parseDate("12/03/2016"), 90.0, image_path);
		addItemToDb("Onion", 40, parseDate("19/05/2015"), 10.5, image_path);
		addItemToDb("Cucumber", 25, parseDate("14/02/2015"), 8.5, image_path);
		addItemToDb("Radish", 6, parseDate("25/03/2015"), 4.5, image_path);
		addItemToDb("Blue Cheese", 2, parseDate("6/08/2016"), 80.0, image_path);
		addItemToDb("Fish", 20, parseDate("17/02/2015"), 40.0, image_path);
		addItemToDb("Beef", 12, parseDate("5/02/2015"), 55.5, image_path);
		addItemToDb("Chicken", 30, parseDate("29/01/2015"), 10.0, image_path);
		addItemToDb("Pork", 1, parseDate("30/01/2015"), 34.5, image_path);
	}
}
