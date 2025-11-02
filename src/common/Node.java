package common;

/**
 * Node class for Linked List implementation.
 *
 * @param <T> the type of data stored in the node
 */
public class Node<T> {
    T data;
    Node<T> next;

    /**
     * Constructs a node with data and next reference.
     *
     * @param data the data to store
     * @param next reference to the next node
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Constructs a node with only data (next is null).
     *
     * @param data the data to store
     */
    public Node(T data) {
        this(data, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}