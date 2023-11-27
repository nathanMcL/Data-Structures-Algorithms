import java.util.List;

public class BalanceSums {

    public static String balanceSums(List<Integer> arr) {
        int n = arr.size();
        int totalSum = 0;

        // Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            totalSum += arr.get(i);
        }

        int leftSum = 0;

        // Iterate through the array and check if there's an element that satisfies the condition
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - arr.get(i);

            // Check if the left and right sums are equal
            if (leftSum == rightSum) {
                return "YES";
            }

            // Add the current element to the left sum for the next iteration
            leftSum += arr.get(i);
        }

        // If the loop completes without finding a balance point, return "NO"
        return "NO";
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> arrayExample = List.of(1, 2, 3, 4, 10, 15);
        System.out.println(balanceSums(arrayExample)); // Output: "YES" or "NO" depending on the array
    }
}
