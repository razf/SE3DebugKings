package eShop;


public interface ILoginSystem {
	
	class RegistrationErrorException extends RuntimeException {}
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
													IllegalUsernameException;
	
	void isEmailValid(String email) throws IllegalEmailException, EmailAlreadyExistsException;
	
	//return 1 for low, 2 for medium, 3 for strong
	int checkPasswordStrengh(String password);
	
	void LoginToSystem(String username, String password) throws UserNotFoundException, 
																IncorrectPasswordException;
	
	
	void CheckCreditCardDetails(String cardNumber, String company) throws InvalidCardNumberException;
	
	void RegisterUser(String username, String password, String email, String cardNumber, String company) throws RegistrationErrorException;
	
	void RecoverLostPassword(String email, String username) throws IllegalUsernameException, 
																	UnableToSendMailException, 
																	UsernameDoesntExistException;
	
	void RecoverLostPassword(String email) throws UnableToSendMailException, 
													EmailDoesntExistException;
}
