package eShop;
import java.sql.*;

@SuppressWarnings("serial")
public interface ILoginSystem { ////change//change//change
	enum PasswordRank{
		LOW, MEDIUM, HIGH
	}
	
	class LoginFormException extends Exception {}
	class UserNotFoundException extends LoginFormException {}
	class IncorrectPasswordException extends LoginFormException {}
	class IllegalUsernameException extends LoginFormException {}
	class IllegalPasswordException extends LoginFormException {}
	class IllegalEmailException extends LoginFormException {}
	class UsernameAlreadyExistsException extends LoginFormException {}
	class EmailAlreadyExistsException extends LoginFormException {}
	class UnableToSendMailException extends LoginFormException {}
	class UsernameDoesntExistException extends LoginFormException {}
	class EmailDoesntExistException extends LoginFormException {}
	class InvalidCardNumberException extends LoginFormException {}

	
	void isUsernameValid(String username) throws UsernameAlreadyExistsException,
													IllegalUsernameException, SQLException;
	
	void isEmailValid(String email) throws IllegalEmailException, EmailAlreadyExistsException, SQLException;
	
	//return 1 for low, 2 for medium, 3 for strong
	PasswordRank checkPasswordStrengh(String password) throws IllegalPasswordException;
	
	void LoginToSystem(String username, String password) throws UserNotFoundException, 
																IncorrectPasswordException, SQLException;
	
	
	void CheckCreditCardDetails(String cardNumber) throws InvalidCardNumberException, SQLException;
	
	void RegisterUser(String username, String password, String email, String cardNumber, String company) throws SQLException;
	
	void RecoverLostPassword(String email, String username) throws IllegalUsernameException, 
																	UnableToSendMailException, 
																	UsernameDoesntExistException,
																	SQLException;
	
	void RecoverLostPassword(String email) throws UnableToSendMailException, 
													EmailDoesntExistException,
													SQLException;
}
