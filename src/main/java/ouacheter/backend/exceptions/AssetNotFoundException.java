package ouacheter.backend.exceptions;

public class AssetNotFoundException extends RuntimeException  {
    public AssetNotFoundException(int id) {
        super("Could not find Asset " + id);
    }
}
