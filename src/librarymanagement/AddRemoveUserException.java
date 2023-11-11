package librarymanagement;

public class AddRemoveUserException extends Exception {

	AddRemoveUserException(String error) {
		super(error);
	}
	
	public static class RemoveEmpty extends AddRemoveUserException {

		RemoveEmpty() {
			super("No user was selected to be removed");
			// TODO Auto-generated constructor stub
		}
		
	}
	
}
