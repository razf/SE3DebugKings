package eShopTests;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import eShop.DBManager;

import java.sql.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class DBTest {

	@Test
	public void testCreation() {
		DBManager manager = new DBManager(); //tests the database creation. will create a new db if none is available.
	}

}
