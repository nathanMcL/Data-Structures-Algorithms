// Chpt 5,pg 167 5-4
//  An unimodal array has only one peak or maximum element, and you know that if the sequence is increasing,
//  the peak is to the right, and if it is decreasing, the peak is to the left.

// Start with two pointers, one at the beginning of the array (low) and one at the end (high).
// Find the middle element of the current subarray (you can do this by mid = low + (high - low) / 2).
// Compare the middle element with its neighbors
// (make sure to handle the edge cases where mid is at the beginning or end of the array).
// If array[mid] > array[mid - 1] and array[mid] > array[mid + 1],
// then array[mid] is the maximum, and you can return it.
// If array[mid - 1] < array[mid] and array[mid] < array[mid + 1],
// this means you're on the increasing slope, so you set low = mid + 1.
// If array[mid - 1] > array[mid] and array[mid] > array[mid + 1],
// this means you're on the decreasing slope, so you set high = mid - 1.
// Repeat steps 2 and 3 until you find the maximum element.



public class UnimodalArray {
    public static int findMaximumInUnimodalArray(int[] unimodalArray) {
        int low = 0;
        int high = unimodalArray.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if the mid is the peak
            if ((mid == 0 || unimodalArray[mid] > unimodalArray[mid - 1]) &&
                    (mid == unimodalArray.length - 1 || unimodalArray[mid] > unimodalArray[mid + 1])) {
                return unimodalArray[mid]; // mid is the maximum
            }

            if (mid < unimodalArray.length - 1 && unimodalArray[mid] < unimodalArray[mid + 1]) {
                // If the sequence is still increasing, move to the right half
                low = mid + 1;
            } else {
                // Otherwise, move to the left half
                high = mid;
            }
        }

        return unimodalArray[low]; // low should be at the maximum element
    }

    public static void main(String[] args) {
        // Example usage:
        int[] unimodalArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 20, 18, 16, 14, 12, 10, 8, 6, 4, 2};
        int maxElement = findMaximumInUnimodalArray(unimodalArray);
        System.out.println("The maximum element is: " + maxElement);
    }
}