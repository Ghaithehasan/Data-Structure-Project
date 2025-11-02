package Exeptions;
/**
 * Exception thrown when attempting to enqueue to a full queue.
 */
public class QueueOverflowException extends RuntimeException {
    public QueueOverflowException(String message) {
        super(message);
    }
}