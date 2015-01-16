package eShop;

public class DummyLoginSystem implements ILoginSystem {

	@Override
	public void isUsernameValid(String username)
			throws UsernameAlreadyExistsException, IllegalUsernameException {
		throw new UsernameAlreadyExistsException();
		// TODO Auto-generated method stub

	}

	@Override
	public void isEmailValid(String email) throws IllegalEmailException,
			EmailAlreadyExistsException {
		throw new IllegalEmailException();
		// TODO Auto-generated method stub

	}

	@Override
	public int checkPasswordStrengh(String password) {
		
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void LoginToSystem(String username, String password)
			throws UserNotFoundException, IncorrectPasswordException {
		throw new UserNotFoundException();
		// TODO Auto-generated method stub

	}

	@Override
	public void CheckCreditCardDetails(String cardNumber, String company)
			throws InvalidCardNumberException {
		throw new InvalidCardNumberException();
		// TODO Auto-generated method stub

	}

	@Override
	public void RegisterUser(String username, String password, String email,
			String cardNumber, String company) throws RegistrationErrorException {
		
		// TODO Auto-generated method stub

	}

	@Override
	public void RecoverLostPassword(String email, String username)
			throws IllegalUsernameException, UnableToSendMailException,
			UsernameDoesntExistException {
		throw new IllegalUsernameException();
		// TODO Auto-generated method stub

	}

	@Override
	public void RecoverLostPassword(String email)
			throws UnableToSendMailException, EmailDoesntExistException {
		throw new EmailDoesntExistException();
		// TODO Auto-generated method stub

	}

}
