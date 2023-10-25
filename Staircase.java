// Chapter 8: Recursion, Dynamic Programming
// p. 130-134
// Problem 8.1

// a child is running up a staircase with n steps and can hop either
// 1 step , 2 steps, or 3 steps at a time.
// Implement a method to count how many possible ways a child can run up the stairs?

// There's 1 way to climb a staircase of 0 steps. not to step.
// There's 1 way to climb a staircase of 1 step.
// There are 2 ways to climb a staircase of 2 steps: (1,1) and (2).
// There are 4 ways to climb a staircase of 3 steps: (1,1,1), (1,2), (2,1), and (3).


public class Staircase {

    public static void main(String[] args) {
        int n = 5; // start at number 10. then changed numbers
        System.out.println(countWays(n)); // // Print the number of ways to climb the staircase
    }

    // Computes the number of ways to climb a staircase with n steps.
    public static int countWays(int n) {
        // If the staircase has a negative number of steps, return 0 (invalid input)
        if (n < 0) {
            return 0;
        // If the staircase has 0 steps, return 1 (only one way to "climb" it)
        } else if (n == 0) {
            return 1;
        }

        // Dynamic Programming (dp) array to store the number of ways for each step to count
        int[] dp = new int[n+1];
        
        // Base cases
        dp[0] = 1; // 1 way to climb 0 steps
        dp[1] = 1; // 1 way to climb 1 step
        dp[2] = 2; // 2 ways to climb 2 steps
        dp[3] = 4; // 4 ways to climb 3 steps


        // For each number of steps from 4 to n, calculate the number of ways
        // by summing the ways to climb the previous 3 step counts
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        // Return the number of ways to climb the staircase of n steps
        return dp[n];

    }

}