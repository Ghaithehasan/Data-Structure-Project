package MyStack;

import Exeptions.StackOverflowException;
import Exeptions.StackUnderflowException;

/**
 * A generic Stack implementation using an array.
 * Follows LIFO (Last In First Out) principle.
 *
 * @param <T> the type of elements in this stack
 */
public class ArrayStack<T> implements Stack<T> {
    private T[] stackArray;
    private int top;
    private int capacity;

    /**
     * Constructs a stack with the specified capacity.
     *
     * @param capacity the maximum number of elements the stack can hold
     * @throws IllegalArgumentException if capacity is less than 1
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be at least 1");
        }
        this.capacity = capacity;
        this.stackArray = (T[]) new Object[capacity];
        this.top = -1; // -1 indicates empty stack
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param element the element to push
     * @throws StackOverflowException if the stack is full
     * @throws IllegalArgumentException if element is null
     */
    public void push(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot push null element");
        }
        if (isFull()) {
            throw new StackOverflowException("Stack is full. Cannot push element.");
        }
        stackArray[++top] = element;
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws StackUnderflowException if the stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty. Cannot pop element.");
        }
        T element = stackArray[top];
        stackArray[top--] = null; // Help garbage collection
        return element;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws StackUnderflowException if the stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty. Cannot peek.");
        }
        return stackArray[top];
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Checks if the stack is full.
     *
     * @return true if the stack is full, false otherwise
     */
    public boolean isFull() {
        return top == capacity - 1;
    }

    /**
     * Returns the current number of elements in the stack.
     *
     * @return the number of elements
     */
    public int size() {
        return top + 1;
    }

    /**
     * Returns the maximum capacity of the stack.
     *
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Removes all elements from the stack.
     */
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    /**
     * Returns a string representation of the stack.
     *
     * @return string representation showing all elements from bottom to top
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack: []";
        }
        StringBuilder sb = new StringBuilder("Stack: [");
        for (int i = 0; i <= top; i++) {
            sb.append(stackArray[i]);
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("] <- top");
        return sb.toString();
    }
}


