package librarymanagement;

public class SignUpException extends Exception {
	public SignUpException(String error) {
		super(error);
	}
	
	public static class EmptyFirstName extends SignUpException {

		public EmptyFirstName() {
			super("Exception: Empty first name field");
		}
		
	}
	public static class EmptyLastName extends SignUpException {

		public EmptyLastName() {
			super("Exception: Empty last name field");
		}
		
	}
	
	public static class EmptyPhoneNumber extends SignUpException {

		public EmptyPhoneNumber() {
			super("Exception: Empty phone number field");
		}
		
	}
	
	public static class InvalidPhoneNumber extends SignUpException {
		public InvalidPhoneNumber() {
			super("Exception: Phone number contains non-digits");
		}
	}
	
	public static class InvalidPhoneNumberLength extends SignUpException {
		public InvalidPhoneNumberLength() {
			super("Exception: Phone number is not 9 digits");
		}
	}
	
	public static class InvalidFirstName extends SignUpException {

		public InvalidFirstName() {
			super("Exception: First name contains non-letters");
		}
		
	}
	
	public static class InvalidLastName extends SignUpException {

		public InvalidLastName() {
			super("Exception: Last name contains non-letters");
		}
		
	}
	public static class PhoneNumberAlreadyUsed extends SignUpException {

		public PhoneNumberAlreadyUsed() {
			super("Exception: This phone number is already registered");
		}
		
	}
	public static class EmptyPassword extends SignUpException {

		public EmptyPassword() {
			super("Exception: Password needs at least 1 character");
		}
	}
}
