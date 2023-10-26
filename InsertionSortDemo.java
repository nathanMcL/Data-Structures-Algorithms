// Define the InsertionSortDemo class
public class InsertionSortDemo {

    // A method to perform insertion sort on the given array
    public static void sort(int[] arr) {
        
        // Start from the second element and go up to the last
        for (int i = 1; i < arr.length; i++) {
            
            // Take the current element as the key to be inserted 
            // in the sorted part of the array
            int key = arr[i];
            
            // Initialize 'j' as the position just before 'i'
            int j = i - 1;

            // Shift all elements greater than the 'key' to the right
            // in the sorted portion of the array
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            
            // Insert the 'key' in its correct position in the sorted portion
            arr[j + 1] = key;
        }
    }

    // The main method to test the insertion sort
    public static void main(String[] args) {
        
        // Sample array to be sorted
        int[] arr = {12, 11, 13, 5, 6};

        // Print the original array
        System.out.println("Original Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Sort the array using the sort method
        sort(arr);

        // Print the sorted array
        System.out.println("Sorted Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
