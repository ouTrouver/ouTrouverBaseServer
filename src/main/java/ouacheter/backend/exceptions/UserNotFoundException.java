package ouacheter.backend.exceptions;



public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super("Could not find employee " + id);
    }
    public UserNotFoundException(int id) {
        super("Could not find employee " + id);
    }
}
