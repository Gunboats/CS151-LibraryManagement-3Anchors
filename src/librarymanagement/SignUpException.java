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

	public static class InvalidPassword extends SignUpException {

		public InvalidPassword() {
			super("Exception: Password does not satisfied the following requirements" + "\n" +
					"At least 8 chars" + 
					"\n" +
					"Contains at least one digit" + 
					"\n" +
					"Contains at least one lower alpha char and one upper alpha char" + 
					"\n" + 
					"Contains at least one char within a set of special chars (@#%$^ etc.)" + 
					"\n" +
					"Does not contain space, tab, etc.");
		}
	}
}
