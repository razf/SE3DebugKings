package eShopTests;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import eShop.DatabaseFillerAndCreator;

import java.sql.*;

import static org.junit.Assert.*;

import org.junit.Test;
@SuppressWarnings("unused")
public class DBTest {

	@Test 
	public void testCreation() {
		DatabaseFillerAndCreator filler = new DatabaseFillerAndCreator(); //tests the database creation. will create a new db if none is available.
	}

}
