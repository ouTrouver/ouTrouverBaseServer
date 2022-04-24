package ouacheter.backend.exceptions;

public class ShopNotFoundException extends RuntimeException  {
    public ShopNotFoundException(int id) {
        super("Could not find Shop " + id);
    }
}
