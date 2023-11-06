// We maintain a running total of the sum of array elements as we iterate through the array (currentSum),
// and we calculate this sum modulo m.
// At each step, we check if the current prefix sum gives us a better maximum sum modulo m than we have seen before.
// We use the TreeSet to find a prefix sum that we have previously seen that is just greater than the current prefix sum.
// If such a prefix sum exists, we calculate the difference,
// which represents a wrap-around case where subtracting a smaller prefix sum earlier in the array from
// the current sum could give us a larger value modulo m.
// We store each prefix sum in the TreeSet to use for this check as we iterate through the array.
// Finally, we return the maximum sum modulo m that we found.

// To solve this problem efficiently, you can use a more advanced data structure,
// such as a balanced binary search tree (like a TreeSet in Java),
// which can give you a time complexity of O(n log n).
//The idea is to iterate through the array, keeping track of the prefix sums modulo m, and for each prefix sum,
// finding the smallest prefix sum that is greater than or equal to it (if such a sum exists)
// to find the largest modulus less than m.

import java.util.TreeSet;

public class MaximumSubarraySumModuloM {

    /**
     * Determines the maximum value of the sum of the subarrays modulo m.
     *
     * @param a An array of integers to analyze.
     * @param m The modulo divisor.
     * @return The maximum subarray sum modulo m.
     */
    public static long maximumSum(long[] a, long m) {
        long maxSum = 0;
        TreeSet<Long> prefixSums = new TreeSet<>();
        long currentSum = 0;

        // Initialize prefixSums with zero to consider subarrays starting at index 0
        prefixSums.add(0L);

        // Iterate over the array to calculate prefix sums and find maximum sum modulo m
        for (long value : a) {
            currentSum = (currentSum + value) % m;
            maxSum = Math.max(maxSum, currentSum); // Check if a current prefix sum gives a better result

            // Find the smallest prefix sum greater than currentSum
            Long higher = prefixSums.higher(currentSum);
            if (higher != null) {
                // Update maxSum if we find a larger sum that wraps around m
                maxSum = Math.max(maxSum, (currentSum - higher + m) % m);
            }

            // Add the current prefix sum to the set
            prefixSums.add(currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        long[] a = {3, 3, 9, 9, 13, 11, 15, 17};
        long m = 7;
        System.out.println("Maximum subarray sum modulo " + m + " is: " + maximumSum(a, m));
    }
}

