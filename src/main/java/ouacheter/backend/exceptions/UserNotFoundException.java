package ouacheter.backend.exceptions;



public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super("Could not find employee " + id);
    }
    public static void TokenNotFound(String id) {
        System.out.println("Could not find employee with the token " + id);
    }
    public UserNotFoundException(int id) {
        super("Could not find employee " + id);
    }
}
