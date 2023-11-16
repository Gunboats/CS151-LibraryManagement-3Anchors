package librarymanagement;


public class LoginException extends Exception {
	public LoginException(String error) {
		super(error);
	}
	
	
	public static class EmptyUsername extends LoginException {

		public EmptyUsername() {
			super("Exception: Empty username field");
		}
		
	}
	
	public static class EmptyPassword extends LoginException {

		public EmptyPassword() {
			super("Exception: Empty password field");
		}
		
	}
	
	public static class IncorrectUsernamePasswordCombo extends LoginException {

		public IncorrectUsernamePasswordCombo() {
			super("Exception: Incorrect password and username combination");
		}
		
	}
	
}

