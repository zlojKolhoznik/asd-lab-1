package dataStructures;

/**
 * DoubleLinkedList is a data structure that contains a sequence of elements in which every element has a link to the previous and the next element in the sequence.
 */
public class DoubleLinkedList {
    private Node head;  // First element of the list.
    private Node tail;  // Last element of the list.
    public int size;    // Number of elements in the list.

    // Adds an element to the end of the list.
    public void append(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }

        tail = newNode;
        size++;
    }

    // Adds an element to the beginning of the list.
    public void prepend(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            tail = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
        }

        head = newNode;
        size++;
    }

    // Adds an element to the list at the specified index.
    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0 || isEmpty()) {
            prepend(value);
        } else if (index == size) {
            append(value);
        } else {
            Node newNode = new Node(value);
            Node current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
            size++;
        }
    }

    // Removes the first element from the list.
    public void removeFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        head = head.next;
        head.previous = null;
        size--;
    }

    // Removes the last element from the list.
    public void removeLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        tail = tail.previous;
        tail.next = null;
        size--;
    }

    // Removes the element at the specified index from the list.
    public void remove(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        if (index <= 0) {
            removeFirst();
        } else if (index >= size - 1) {
            removeLast();
        } else {
            Node current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
        }
    }

    // Checks is the list is empty.
    public boolean isEmpty() {
        return head == null;
    }

    // Returns the element at the specified index.
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }
}

class Node {
    int value;      // Value of the element.
    Node next;      // Link to the next element.
    Node previous;  // Link to the previous element.

    Node(int value) {
        this.value = value;
    }
}
