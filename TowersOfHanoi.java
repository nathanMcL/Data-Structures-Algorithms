// Chapter 8: Recursion, Dynamic Programming
// p. 130-134
// Problem 8.6
// Solution pg 353

// The Towers of Hanoi, is a classic recursive problem.
// To complete the challange I folloed this method:
// Move the top n-1 disks from the source to an auxiliary peg.
// Move the largest disk (nth disk) from the source to the destination peg.
// Move the n-1 disks from the auxiliary peg to the destination peg.

import java.util.Stack;

public class TowersOfHanoi {

    // Inner class representing each tower
    private static class Tower {
        // Stack to hold disks. An integer represents each disk's size
        private Stack<Integer> disks;
        private int index;

        // Constructor initializing the tower with an index of i
        public Tower(int i) {
            disks = new Stack<Integer>();
            index = i;
        }

        // Getter for the index of the towers
        public int index() {
            return index;
        }

        // Method to add a disk to the tower
        public void add(int d) {
            // check if there is a smaller disk on top
            if (!disks.isEmpty() && disks.peek() <= d) {
                System.out.print("Error placing disk " + d);
            } else {
                disks.push(d);
            }
        }

        // Method to move the top disk of this tower to another tower
        public void moveTopTo(Tower t) {
            int top = disks.pop(); // Pop the top disk
            t.add(top); // Add the disk to the destination tower
            System.out.println("Move disk " + top + " from " + index() + " to " + t.index());
        }

        // Recursive method to solve the Tower of Hanoi, (we want to move the disks)
        public void moveDisks(int quantity, Tower destination, Tower buffer) {
            // Base case: nothing to move
            if (quantity <= 0) return;

            // Step 1: Move the top n-1 disks from the source to buffer, using the destination as a buffer
            moveDisks(quantity -1, buffer, destination);

            // Step 2: Move the nth disk from the source to destination
            moveTopTo(destination);

            // Step 3: Move the n-1 disks from buffer to destination, using the source as the buffer
            buffer.moveDisks(quantity -1, destination, this);
        }
    }

    public static void main(String[] args) {
        int n = 3; // The number of disks

        // Initializing the three towers
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        // Add disks to the first tower in descending order, largest at the bottom
        for (int i = n; i > 0; i--) {
            towers[0].add(i);
        }

        // Solve the puzzle by moving disks from the first tower to the last tower :)
        towers[0].moveDisks(n, towers[2], towers[1]);
    }
}
