package eShop;

import java.sql.*;
import java.util.regex.Pattern;




public class LoginSystem implements ILoginSystem {
	private DBManager shopDB;
	@Override
	public void isUsernameValid(String username)
			throws UsernameAlreadyExistsException, IllegalUsernameException, SQLException {
		Pattern p = Pattern.compile("[^a-zA-Z0-9]");  //Checks if string contains something not alphanumeric.
		if (username.length() > 8 || p.matcher(username).find())
			throw new IllegalUsernameException();
		Statement query = shopDB.getConnection().createStatement();
		ResultSet queryResult = query.executeQuery("SELECT USERNAME FROM USERS WHERE USERNAME = " + username);
		if(queryResult.next())
			throw new UsernameAlreadyExistsException();
	}

	@Override
	public void isEmailValid(String email) throws IllegalEmailException,
			EmailAlreadyExistsException, SQLException {
		Pattern p = Pattern.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
		if (!p.matcher(email).find())
			throw new IllegalEmailException();
		Statement query = shopDB.getConnection().createStatement();
		ResultSet queryResult = query.executeQuery("SELECT EMAIL FROM USERS WHERE EMAIL = " + email);
		if(queryResult.next())
			throw new EmailAlreadyExistsException();
	}

	@Override
	public PasswordRank checkPasswordStrengh(String password) throws IllegalPasswordException{
		Pattern valid = Pattern.compile("[^a-zA-Z0-9]");
		if (password.length() < 6 || password.length() > 12 || !valid.matcher(password).find()) //checks password validity.
			throw new IllegalPasswordException();
		Pattern numbers = Pattern.compile("[^0-9]");
		Pattern lowercase = Pattern.compile("[^a-z]");
		Pattern uppercase = Pattern.compile("[^A-Z]");
		if (!numbers.matcher(password).find() || !lowercase.matcher(password).find()) //checks if password contains only numbers or only lowercase letters.
			return PasswordRank.LOW;
		else if (!uppercase.matcher(password).find())
			return PasswordRank.MEDIUM;
		else
			return PasswordRank.HIGH;
	}

	@Override
	public void LoginToSystem(String username, String password)
			throws UserNotFoundException, IncorrectPasswordException, SQLException {
		Statement query = shopDB.getConnection().createStatement();
		ResultSet queryResult = query.executeQuery("SELECT USERNAME FROM USERS WHERE USERNAME = " + username);
		if(!queryResult.next())
			throw new UserNotFoundException();
		ResultSet secondQueryResult = query.executeQuery("SELECT USERNAME FROM USERS WHERE USERNAME = " + username + " AND PASSWORD = " + password);
		if(!secondQueryResult.next())
			throw new IncorrectPasswordException();
	}

	@Override
	public void CheckCreditCardDetails(String cardNumber)
			throws InvalidCardNumberException, SQLException {
		if (cardNumber.length() != 16)
			throw new InvalidCardNumberException();

	}

	@Override
	public void RegisterUser(String username, String password, String email,
			String cardNumber, String company)
			throws SQLException {
		Statement query = shopDB.getConnection().createStatement();
		query.execute("INSERT INTO USERS (USERNAME, PASSWORD, EMAIL, CREDIT_NUM, CREDIT_COMPANY)"+
				"VALUES ("+username+", "+password+", "+email+", "+cardNumber+", "+company+")");
	}

	@Override
	public void RecoverLostPassword(String email, String username)
			throws IllegalUsernameException, UnableToSendMailException,
			UsernameDoesntExistException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void RecoverLostPassword(String email)
			throws UnableToSendMailException, EmailDoesntExistException, SQLException {
		// TODO Auto-generated method stub

	}

}
