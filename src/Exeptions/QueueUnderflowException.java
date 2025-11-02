package Exeptions;

/**
 * Exception thrown when attempting to dequeue or peek from an empty queue.
 */
public class QueueUnderflowException extends RuntimeException {
    public QueueUnderflowException(String message) {
        super(message);
    }
}
