// This program is just a different version of MissingNumberFinder
// The only difference in this program is that it searches for all the missing number within the array.
//This approach is O(n) because each element of the array is visited exactly once.
// If the missing number is at the end of the array (i.e., n+1).

import java.util.ArrayList;
import java.util.List;

public class Missing_Numbers_Finder {

    public static List<Integer> findMissingNumbers(int[] array) {
        List<Integer> missingNumbers = new ArrayList<>();
        int expectedNumber = 1;

        for (int num : array) {
            while (num != expectedNumber) {
                missingNumbers.add(expectedNumber);
                expectedNumber++;
            }
            expectedNumber++;  // Move to the next expected number
        }

        // After the loop, check if there are missing numbers at the end
        while (expectedNumber <= array.length + 1) {
            missingNumbers.add(expectedNumber);
            expectedNumber++;
        }

        return missingNumbers;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 6, 7, 9, 10};
        List<Integer> missingNumbers = findMissingNumbers(array);
        System.out.println("The missing numbers are: " + missingNumbers);
    }
}
