package MyQueue;

import Exeptions.QueueUnderflowException;
import common.Node;

/**
 * A generic Queue implementation using Linked List.
 * Follows FIFO (First In First Out) principle.
 * Dynamic size - no capacity limit.
 *
 * @param <T> the type of elements in this queue
 */
public class LinkedListQueue<T> {
    private Node<T> front;  // Points to the first element (for dequeue)
    private Node<T> rear;   // Points to the last element (for enqueue)
    private int size;

    /**
     * Constructs an empty queue.
     */
    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    /**
     * Adds an element to the rear of the queue.
     * Time Complexity: O(1)
     *
     * @param element the element to add
     * @throws IllegalArgumentException if element is null
     */
    public void enqueue(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot enqueue null element");
        }

        Node<T> newNode = new Node<>(element);

        if (isEmpty()) {
            // First element: both front and rear point to it
            front = rear = newNode;
        } else {
            // Add to the end and update rear
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the element at the front of the queue.
     * Time Complexity: O(1)
     *
     * @return the element at the front of the queue
     * @throws QueueUnderflowException if the queue is empty
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is empty. Cannot dequeue element.");
        }

        T data = front.getData();
        front = front.getNext();

        // If queue becomes empty, update rear to null
        if (front == null) {
            rear = null;
        }

        size--;
        return data;
    }

    /**
     * Returns the element at the front of the queue without removing it.
     * Time Complexity: O(1)
     *
     * @return the element at the front of the queue
     * @throws QueueUnderflowException if the queue is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is empty. Cannot peek.");
        }
        return front.getData();
    }

    /**
     * Returns the element at the rear of the queue without removing it.
     * Time Complexity: O(1)
     *
     * @return the element at the rear of the queue
     * @throws QueueUnderflowException if the queue is empty
     */
    public T peekRear() {
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is empty. Cannot peek rear.");
        }
        return rear.getData();
    }

    /**
     * Checks if the queue is empty.
     * Time Complexity: O(1)
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Returns the current number of elements in the queue.
     * Time Complexity: O(1)
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }

    /**
     * Removes all elements from the queue.
     * Time Complexity: O(1)
     */
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * Searches for an element in the queue.
     * Returns true if found, false otherwise.
     * Time Complexity: O(n)
     *
     * @param element the element to search for
     * @return true if element exists, false otherwise
     */
    public boolean contains(T element) {
        Node<T> current = front;

        while (current != null) {
            if (current.getData().equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Returns the position of an element in the queue (1-based from front).
     * Time Complexity: O(n)
     *
     * @param element the element to search for
     * @return position from front (1-based), or -1 if not found
     */
    public int indexOf(T element) {
        Node<T> current = front;
        int position = 1;

        while (current != null) {
            if (current.getData().equals(element)) {
                return position;
            }
            current = current.getNext();
            position++;
        }
        return -1;
    }

    /**
     * Returns a string representation of the queue.
     * Shows elements from front to rear.
     * Time Complexity: O(n)
     *
     * @return string representation
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Queue: [] (empty)";
        }

        StringBuilder sb = new StringBuilder("Queue (front to rear): [");
        Node<T> current = front;

        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(" <- ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Converts the queue to an array.
     * Time Complexity: O(n)
     *
     * @return array containing all elements in order
     */
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = front;
        int index = 0;

        while (current != null) {
            array[index++] = current.getData();
            current = current.getNext();
        }
        return array;
    }

    /**
     * Reverses the queue in place.
     * Time Complexity: O(n)
     */
    public void reverse() {
        if (isEmpty() || size == 1) {
            return;
        }

        Node<T> prev = null;
        Node<T> current = front;
        Node<T> next = null;

        // Swap front and rear
        rear = front;

        // Reverse the linked list
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        front = prev;
    }

    /**
     * Creates a copy of the queue.
     * Time Complexity: O(n)
     *
     * @return a new queue with the same elements
     */
    public LinkedListQueue<T> clone() {
        LinkedListQueue<T> clonedQueue = new LinkedListQueue<>();

        if (isEmpty()) {
            return clonedQueue;
        }

        Node<T> current = front;
        while (current != null) {
            clonedQueue.enqueue(current.getData());
            current = current.getNext();
        }

        return clonedQueue;
    }
}

/**
 * Exception thrown when attempting to dequeue or peek from an empty queue.
 */
