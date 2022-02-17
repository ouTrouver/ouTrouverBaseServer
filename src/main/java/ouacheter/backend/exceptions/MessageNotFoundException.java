package ouacheter.backend.exceptions;

public class MessageNotFoundException extends RuntimeException  {
    public MessageNotFoundException(int id) {
        super("Could not find Message " + id);
    }
}
