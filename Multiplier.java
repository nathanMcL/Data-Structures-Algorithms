//Chapter 8: Recursion, Dynamic Programming
// p. 130-134
// Problem 8.5
// Use pg 350 for help

//  Write a recursive function that multiplies two positive integers without using the  * operator.
// You can use addition, subtraction, and bit shifting, 
// but you should minimize the number of those operations.

// Write down both numbers in two columns. I use 12 and 5 in this example.
// Halve the number in the first column (ignoring any remainders) and double the number in the second column.
// If the number in the first column is even, cross out that entire row.
// Continue halving and doubling until the number in the first column is 1.
// Add up the remaining numbers in the second column. This sum will be the product of the two numbers.

public class Multiplier {

    public static void main(String[] args) {
        System.out.println(multiply(12, 5)); // Expected output: 60
    }

    public static int multiply(int a, int b) {
        // Base case: if b is 0, the result is 0 regardless of a
        if (b == 0) {
            return 0;
        }

        // If b is even, double a and halve b
        if ((b & 1) == 0) {
            return multiply(a << 1, b >> 1);
        }

        // If b is odd, add a to the result of the next recursive call
        return a + multiply(a << 1, b >> 1);
    }
}
