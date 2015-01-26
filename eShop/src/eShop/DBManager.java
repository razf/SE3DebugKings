package eShop;


import java.sql.*;

/*
 * for main:
 * 		create db. aft3

 */
public class DBManager { //change
	private Connection dbConnection;
	
	private void setDBDir() {
	    // Decide on the db system directory: <userhome>/.addressbook/
	    String projectDir = System.getProperty("user.dir", ".");
	    String systemDir = projectDir + "/.shopDB";
	
	    // Set the db system directory.
	    System.setProperty("derby.system.home", systemDir);
		
	    // Create the DB.
	}
	
	private void createDB() {
		dbConnection = null;
		String strUrl = "jdbc:derby:ShopDB;create=true";	
		try {
		    dbConnection = DriverManager.getConnection(strUrl);
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		String createUsers = "CREATE TABLE USERS (" +
					" USER_ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
	                " USERNAME VARCHAR(8), " +
	                " PASSWORD VARCHAR(12), " + 
	                " EMAIL VARCHAR(100), " + 
	                " CREDIT_NUM VARCHAR(16), " + 
	                " CREDIT_COMPANY VARCHAR(40), " +
	                " ADDRESS_CITY VARCHAR(100), " +
	                " ADDRESS_STREET VARCHAR(100), " +
	                " IS_MANAGER BOOLEAN, " +
	                " ADDRESS_NUM VARCHAR(100)) " ; 
		String createItems = "CREATE TABLE ITEMS (" +
				" BARCODE INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                " ITEM_NAME VARCHAR(100), " +
                " QUANTITY INTEGER, " + 
                " BEST_BY DATE, " + 
                " PRICE DOUBLE, " +
                " IMAGE_PATH LONG VARCHAR) "; 
		String createSpecials = "CREATE TABLE SPECIALS (" +
				" SPECIAL_ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                " DISCOUNT INTEGER, " +
                " ITEM_BUY_BARCODE INTEGER, " +
                " ITEM_FREE_BARCODE INTEGER, " + 
                " ITEM_BUY_AMOUNT INTEGER, " + 
                " ITEM_FREE_AMOUNT INTEGER) "; 
		String createDeliveries = "CREATE TABLE DELIVERIES (" +
				" BOX_ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                " CONTENT LONG VARCHAR, " +
                " USER_ID INTEGER) ";
		String createSales = "CREATE TABLE SALES (" +
				" ITEM_ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                " AMOUNT INTEGER, " +
				" PRICE DOUBLE, " +
                " SALE_DATE DATE, " +
                " SALE_TIME TIME) ";
		try {
	        Statement statement = dbConnection.createStatement();
	        statement.execute(createUsers);
	        statement.execute(createItems);
	        statement.execute(createSpecials);
	        statement.execute(createDeliveries);
	        statement.execute(createSales);
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		 
	}
	
	public DBManager(){
		setDBDir();
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbConnection = null;
		String strUrl = "jdbc:derby:ShopDB;";
		try {
		    dbConnection = DriverManager.getConnection(strUrl);
		} catch (SQLException sqle) {
		    createDB();
		}
	}
	
	public Connection getConnection(){
		return dbConnection;
	}
	
	protected void addItemToDb(String name, int quantity, Date best_by, double price, String image_path){
		try {
			String toExecute = "INSERT INTO ITEMS (ITEM_NAME, QUANTITY, BEST_BY, PRICE, IMAGE_PATH) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement query = dbConnection.prepareStatement(toExecute);
			query.setString(1, name);
			query.setInt(2,  quantity);
			query.setDate(3, best_by);
			query.setDouble(4,  price);
			query.setString(5, image_path);
			query.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void addUserToDb(String username, String password, String email, String credit_num, String credit_company, String address_city, String address_street, boolean is_manager, String address_num){
		try {
			String toExecute = "INSERT INTO USERS (USERNAME, PASSWORD, EMAIL, CREDIT_NUM, CREDIT_COMPANY, ADDRESS_CITY, ADDRESS_STREET, IS_MANAGER, ADDRESS_NUM) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement query = dbConnection.prepareStatement(toExecute);
			query.setString(1, username);
			query.setString(2, password);
			query.setString(3, email);
			query.setString(4, credit_num);
			query.setString(5, credit_company);
			query.setString(6, address_city);
			query.setString(7, address_street);
			query.setBoolean(8, is_manager);
			query.setString(9, address_num);
			query.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
