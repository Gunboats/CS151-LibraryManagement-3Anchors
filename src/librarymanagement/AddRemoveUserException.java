package librarymanagement;

/**
 * Exceptions for when admin tries to remove a user
 */
public class AddRemoveUserException extends Exception {


	AddRemoveUserException(String error) {
		super(error);
	}
	

	public static class RemoveEmpty extends AddRemoveUserException {
	/**
	 * Created and used when the admin tries to remove a user, but no
	 * users were selected with the checkbox in LibraryUserMenu
	 */
		RemoveEmpty() {
			super("No user was selected to be removed");
		}
		
	}
	
}
