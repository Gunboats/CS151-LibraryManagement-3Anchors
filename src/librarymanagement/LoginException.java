package librarymanagement;


public class LoginException extends Exception {
	public LoginException(String error) {
		super(error);
	}
	
	
	public static class EmptyUsername extends LoginException {

		public EmptyUsername() {
			super("Exception: Empty username field");
			// TODO Auto-generated constructor stub
		}
		
	}
	
	public static class EmptyPassword extends LoginException {

		public EmptyPassword() {
			super("Exception: Empty password field");
			// TODO Auto-generated constructor stub
		}
		
	}
	
	public static class IncorrectUsernamePasswordCombo extends LoginException {

		public IncorrectUsernamePasswordCombo() {
			super("Exception: Incorrect password and username combination");
			// TODO Auto-generated constructor stub
		}
		
	}
	
}

