package dataStructures;

import java.util.EmptyStackException;

/**
 * Represents vector-allocated Stack data structure.
 * Stack is a data structure that implements pattern LIFO (last in - first out).
 */

public class VectorStack {
    private String[] elements;          // Contains elements of the stack.
    private int elementsCount = 0;      // Number of elements in the stack.
    private int topIndex = -1;          // Index of the last added element (top of the stack).

    // Creates a stack with specified size. Size of the stack cannot be changed in the future.
    public VectorStack(int size) {
        elements = new String[size];
    }

    // Adds an element to the stack. Returns true if element was successfully added.
    public boolean add(String element) {
        if (isFull() || !isInteger(element)) {
            return false;
        }

        // Physically add element to stack and update total number of elements and pointer to the top of the stack.
        elements[elementsCount] = element;
        elementsCount++;
        topIndex++;
        return true;
    }

    // Checks if number of elements is equal to size of allocated array.
    public boolean isFull() {
        return elementsCount == elements.length;
    }

    // Since it is specified in the task that stack should contain string representations of integers,
    // we need this method to check if new element is suitable for addition.
    private boolean isInteger(String s) {
        // Try to convert string to Integer. If failed, parseInt throws an NumberFormatException,
        // we catch it and return false. If parseInt does not throw anything, then s is an integer - return true.
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }

    // Get top element of the stack but do not delete it.
    public String peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return elements[topIndex];
    }

    // Get top element of the stack and delete it.
    public String pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        String element = elements[topIndex];
        elements[topIndex] = null;
        topIndex--;
        elementsCount--;
        return element;
    }

    // Check if elementCount is equal to zero to avoid getting elements from empty stack
    public boolean isEmpty() {
        return elementsCount == 0;
    }
}
