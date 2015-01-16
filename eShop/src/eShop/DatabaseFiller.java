package eShop;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatabaseFiller extends DBManager{
	
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
	 
	public DatabaseFiller(){
		String projectDir = System.getProperty("user.dir", ".");
	    String image_path = projectDir + "/.Images/milk.png";
		addItemToDb("milk", 3, parseDate("12/3/2012"), 23.5, image_path);
	}
}
