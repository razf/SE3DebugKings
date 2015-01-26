//package eShop;
//
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class ShoppingCart implements IShoppingCart { //change
//	private Integer[] currentProducts;
//	private DBManager shopDB;
//	
//	public ShoppingCart(){
//		currentProducts = new Integer[20];
//		
//	}
//	@Override
//	public void addToCart(int barcode, int amount) throws CartException {
//		if (barcode>currentProducts.length - 1 || amount <= 0)
//			throw new CartException();
//		currentProducts[barcode] += amount;
//	}
//
//	@Override
//	public void removeFromCart(int barcode, int amount) throws CartException {
//		if (barcode>currentProducts.length - 1 || amount <= 0)
//			throw new CartException();
//		currentProducts[barcode] -= amount;
//		
//	}
//
//	@Override
//	public boolean checkIfStillOk(int barcode) throws CartException {
//		try{
//			String toPrepare = "SELECT BY_DATE FROM ITEMS WHERE BARCODE = ?"; //query the db.
//			PreparedStatement query = shopDB.getConnection().prepareStatement(toPrepare);
//			query.setInt(1, barcode);
//			ResultSet queryResult = query.executeQuery();
//			queryResult.next();
//			Date by_date = queryResult.getDate(1);
//			java.util.Calendar cal = java.util.Calendar.getInstance(); //get today's date
//			java.util.Date utilDate = cal.getTime();
//			java.sql.Date todayDate = new Date(utilDate.getTime());
//			return by_date.after(todayDate); //compare the dates.
//		} catch (Exception e) {
//			throw new CartException();
//		}
//	}
//
//	@Override
//	public int getDiscount(int barcode) throws CartException {
//		try {
//			String toPrepare = "SELECT DISCOUNT FROM SPECIALS WHERE BARCODE = ?"; //query the db.
//			PreparedStatement query = shopDB.getConnection().prepareStatement(toPrepare);
//			query.setInt(1, barcode);
//			ResultSet queryResult = query.executeQuery();
//			if (!queryResult.next())
//				return 0;
//			return queryResult.getInt(1);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 0;
//	}
//
//}
