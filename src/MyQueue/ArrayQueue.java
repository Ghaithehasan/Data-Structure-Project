package MyQueue;

import Exeptions.QueueOverflowException;
import Exeptions.QueueUnderflowException;

public class ArrayQueue<T>{

    private T[] queueArray;
    private int front;      // Index of the first element
    private int rear;       // Index of the last element
    private int size;       // Current number of elements
    private int capacity;   // Maximum capacity

    /**
     * Constructs a queue with the specified capacity.
     *
     * @param capacity the maximum number of elements the queue can hold
     * @throws IllegalArgumentException if capacity is less than 1
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be at least 1");
        }
        this.capacity = capacity;
        this.queueArray = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    /**
     * Adds an element to the rear of the queue.
     * Time Complexity: O(1)
     *
     * @param element the element to add
     * @throws QueueOverflowException if the queue is full
     * @throws IllegalArgumentException if element is null
     */
    public void enqueue(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot enqueue null element");
        }
        if (isFull()) {
            throw new QueueOverflowException("Queue is full. Cannot enqueue element.");
        }

        // Circular increment: move rear to next position
        rear = (rear + 1) % capacity;
        queueArray[rear] = element;
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

        T element = queueArray[front];
        queueArray[front] = null;  // Help garbage collection

        // Circular increment: move front to next position
        front = (front + 1) % capacity;
        size--;

        // Optional: reset pointers when queue becomes empty
        if (isEmpty()) {
            front = 0;
            rear = -1;
        }

        return element;
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
        return queueArray[front];
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
        return queueArray[rear];
    }

    /**
     * Checks if the queue is empty.
     * Time Complexity: O(1)
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the queue is full.
     * Time Complexity: O(1)
     *
     * @return true if the queue is full, false otherwise
     */
    public boolean isFull() {
        return size == capacity;
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
     * Returns the maximum capacity of the queue.
     * Time Complexity: O(1)
     *
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Removes all elements from the queue.
     * Time Complexity: O(n) - to help garbage collection
     */
    public void clear() {
        // Clear all references for garbage collection
        for (int i = 0; i < capacity; i++) {
            queueArray[i] = null;
        }
        front = 0;
        rear = -1;
        size = 0;
    }

    /**
     * Searches for an element in the queue.
     * Time Complexity: O(n)
     *
     * @param element the element to search for
     * @return true if element exists, false otherwise
     */
    public boolean contains(T element) {
        if (isEmpty()) {
            return false;
        }

        int count = 0;
        int index = front;

        while (count < size) {
            if (queueArray[index].equals(element)) {
                return true;
            }
            index = (index + 1) % capacity;
            count++;
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
        if (isEmpty()) {
            return -1;
        }

        int count = 0;
        int index = front;
        int position = 1;

        while (count < size) {
            if (queueArray[index].equals(element)) {
                return position;
            }
            index = (index + 1) % capacity;
            count++;
            position++;
        }
        return -1;
    }

    /**
     * Returns a string representation of the queue.
     * Shows elements from front to rear with array indices.
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
        int count = 0;
        int index = front;

        while (count < size) {
            sb.append(queueArray[index]);
            if (count < size - 1) {
                sb.append(" <- ");
            }
            index = (index + 1) % capacity;
            count++;
        }

        sb.append("] | Size: ").append(size).append("/").append(capacity);
        return sb.toString();
    }

    /**
     * Returns a detailed string showing the internal array state.
     * Useful for debugging and understanding circular behavior.
     *
     * @return detailed representation with indices
     */
    public String toDetailedString() {
        StringBuilder sb = new StringBuilder("Array state: [");

        for (int i = 0; i < capacity; i++) {
            if (queueArray[i] != null) {
                sb.append(queueArray[i]);
            } else {
                sb.append("_");
            }

            // Mark front and rear positions
            if (i == front && i == rear && !isEmpty()) {
                sb.append("(F,R)");
            } else if (i == front) {
                sb.append("(F)");
            } else if (i == rear) {
                sb.append("(R)");
            }

            if (i < capacity - 1) {
                sb.append(", ");
            }
        }

        sb.append("]\nfront=").append(front)
                .append(", rear=").append(rear)
                .append(", size=").append(size)
                .append("/").append(capacity);

        return sb.toString();
    }

    /**
     * Converts the queue to an array in order.
     * Time Complexity: O(n)
     *
     * @return array containing all elements from front to rear
     */
    public Object[] toArray() {
        Object[] array = new Object[size];
        int count = 0;
        int index = front;

        while (count < size) {
            array[count] = queueArray[index];
            index = (index + 1) % capacity;
            count++;
        }
        return array;
    }
}



