import java.util.Arrays;

public class Insert_Merge_Sort {

    public static void main(String[] args) {
        int[] numbers = {12, 3, 21, 8, 1, 47, 50, 88, 3, 13};
        insertionSort(numbers);
        System.out.println("Sorted Numbers using Insertion Sort: " + Arrays.toString(numbers));

        // Test mergeSort
        int[] anotherArray = {38, 27, 43, 3, 9, 82, 10, 21, 8, 1, 47, 50, 88};
        mergeSort(anotherArray);
        System.out.println("Sorted Numbers using Merge Sort: " + Arrays.toString(anotherArray));
    }

    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
        return arr;
    }

    public static int[] mergeSort(int[] arr) {
        return mergeSortHelper(arr, 0, arr.length - 1);
    }

    // Recursive method
    public static int[] mergeSortHelper(int[] arr, int left, int right){
        if(left < right) {
            // Find the middle of the array
            int middle = (left + right) / 2;

            // Recursively sort first and second halves
            mergeSortHelper(arr, left, middle);
            mergeSortHelper(arr, middle + 1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
        return arr;
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int new1 = middle - left + 1;
        int new2 = right - middle;

        // Create temp arrays "L" = left / "R" = right
        int[] L = new int[new1];
        int[] R = new int[new2];

        // Copy data to temp arrays L[] and R[]
        for (int i = 0; i < new1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < new2; j++) {
            R[j] = arr[middle + 1 + j];
        }

        // Merge the temp arrays back into the main array
        int i = 0, j = 0;
        int k = left;
        while (i < new1 && j < new2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < new1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < new2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
