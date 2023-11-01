package librarymanagement;

public class LoginSignUpException extends Exception {
	public LoginSignUpException(String error) {
		super(error);
	}
	
	public static class EmptyFirstName extends LoginSignUpException {

		public EmptyFirstName() {
			super("Exception: Empty first name field");
			// TODO Auto-generated constructor stub
		}
		
	}
	public static class EmptyLastName extends LoginSignUpException {

		public EmptyLastName() {
			super("Exception: Empty last name field");
			// TODO Auto-generated constructor stub
		}
		
	}
	
	public static class EmptyPhoneNumber extends LoginSignUpException {

		public EmptyPhoneNumber() {
			super("Exception: Empty phone number field");
			// TODO Auto-generated constructor stub
		}
		
	}
	
	public static class InvalidPhoneNumber extends LoginSignUpException {
		public InvalidPhoneNumber() {
			super("Exception: Phone number contains non-digits");
		}
	}
	
	public static class InvalidPhoneNumberLength extends LoginSignUpException {
		public InvalidPhoneNumberLength() {
			super("Exception: Phone number contains non-digits");
		}
	}
	
}
