import dataStructures.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoubleLinkedList list = new DoubleLinkedList();
        Random random = new Random(42);    // Used to generate random numbers to fill the stack.
                                                // For testing purposes seed is set to 42.
        int size;
        VectorStack stack;

        // Reading size of the stack from the user.
        System.out.print("Enter the size of the stack: ");
        size = scanner.nextInt();

        // Creating stack of specified size, filling it with random numbers and printing its elements.
        stack = new VectorStack(size);
        System.out.println("Stack of size " + size + " was created. Elements: ");
        for (int i = 0; i < size; i++) {
            stack.add(Integer.toString(random.nextInt(100)));
            System.out.print(stack.peek() + " ");
        }

        // Adding elements to the list according to the task.
        while(!stack.isEmpty()) {
            int element = Integer.parseInt(stack.pop());
            if (element % 2 != 0) {
                list.append(element);
            } else {
                list.prepend(element);
            }
        }

        // Printing list elements.
        System.out.println("\nList elements: ");
        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}