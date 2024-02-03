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
            Node next = getNode(index);

            newNode.next = next;
            newNode.previous = next.previous;
            next.previous.next = newNode;
            next.previous = newNode;
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
            Node toRemove = getNode(index);

            toRemove.previous.next = toRemove.next;
            toRemove.next.previous = toRemove.previous;
            size--;
        }
    }

    // Checks is the list is empty.
    public boolean isEmpty() {
        return head == null;
    }

    // Returns the element at the specified index.
    public int get(int index) {
        return getNode(index).value;
    }

    // Returns node at the specified index or throws IndexOutOfBoundsException if index is out of bounds.
    // This method is used to avoid code duplication.
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current;

        // If index is closer to the beginning of the list, start from the head. Otherwise, start from the tail.
        if (index < size / 2) {
            current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;

            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current;
    }
}

// Node is a class that represents an element of the linked data structure.
class Node {
    int value;      // Value of the element.
    Node next;      // Link to the next element.
    Node previous;  // Link to the previous element.

    Node(int value) {
        this.value = value;
    }
}
