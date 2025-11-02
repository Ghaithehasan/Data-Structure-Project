package MyStack;

import Exeptions.StackUnderflowException;
import common.Node;

/**
 * A generic Stack implementation using Linked List.
 * Follows LIFO (Last In First Out) principle.
 * Dynamic size - no capacity limit.
 *
 * @param <T> the type of elements in this stack
 */
public class LinkedListStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;

    /**
     * Constructs an empty stack.
     */
    public LinkedListStack() {
        this.top = null;
        this.size = 0;
    }

    /**
     * Pushes an element onto the top of the stack.
     * Time Complexity: O(1)
     *
     * @param element the element to push
     * @throws IllegalArgumentException if element is null
     */
    public void push(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot push null element");
        }
        // Create new node and link it to current top
        Node<T> newNode = new Node<T>(element, top);
        top = newNode;
        size++;
    }

    /**
     * Removes and returns the element at the top of the stack.
     * Time Complexity: O(1)
     *
     * @return the element at the top of the stack
     * @throws StackUnderflowException if the stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty. Cannot pop element.");
        }
        T data = top.getData();
        top = top.getNext();  // Move top to next node
        size--;
        return data;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     * Time Complexity: O(1)
     *
     * @return the element at the top of the stack
     * @throws StackUnderflowException if the stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty. Cannot peek.");
        }
        return top.getData();
    }

    /**
     * Checks if the stack is empty.
     * Time Complexity: O(1)
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Returns the current number of elements in the stack.
     * Time Complexity: O(1)
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }

    /**
     * Removes all elements from the stack.
     * Time Complexity: O(1) - just reset references
     */
    public void clear() {
        top = null;
        size = 0;
    }

    /**
     * Searches for an element in the stack.
     * Returns the 1-based position from the top (top = 1).
     * Time Complexity: O(n)
     *
     * @param element the element to search for
     * @return position from top (1-based), or -1 if not found
     */
    public int search(T element) {
        Node<T> current = top;
        int position = 1;

        while (current != null) {
            if (current.getData().equals(element)) {
                return position;
            }
            current = current.getNext();
            position++;
        }
        return -1;  // Not found
    }

    /**
     * Returns a string representation of the stack.
     * Shows elements from top to bottom.
     * Time Complexity: O(n)
     *
     * @return string representation
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack: [] (empty)";
        }

        StringBuilder sb = new StringBuilder("Stack (top to bottom): [");
        Node<T> current = top;

        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(" -> ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }


    /**
     * Reverses the stack in place.
     * Time Complexity: O(n)
     */
    public void reverse() {
        if (isEmpty() || size == 1) {
            return;
        }

        Node<T> prev = null;
        Node<T> current = top;
        Node<T> next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        top = prev;
    }
}

