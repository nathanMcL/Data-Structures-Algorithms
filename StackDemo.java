// A stack is a data structure that follows the Last In First Out (LIFO) principle
// We first create a new stack.
// We push four integers onto the stack.
// We then pop the top value from the stack and print it.
// We peek the top value of the stack without popping it and print it.
// Finally, we print the state of the stack after these operations.

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        // Create a new stack
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Initial Stack: " + stack);

        // Pop an element from the stack
        int poppedValue = stack.pop();
        System.out.println("Popped Value: " + poppedValue);

        // Peek (or view) the top element without popping
        int topValue = stack.peek();
        System.out.println("Top Value: " + topValue);

        System.out.println("Final Stack: " + stack);
    }
}
