package Exeptions;


/**
 * Exception thrown when attempting to push to a full stack.
 */
public class StackOverflowException extends RuntimeException {
    public StackOverflowException(String message) {
        super(message);
    }
}