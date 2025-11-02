package Exeptions;


/**
 * Exception thrown when attempting to pop or peek from an empty stack.
 */
public class StackUnderflowException extends RuntimeException {
    public StackUnderflowException(String message) {
        super(message);
    }
}