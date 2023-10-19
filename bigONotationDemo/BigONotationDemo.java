// This Big-O notation program
// demonstrates the Big-O notation concepts.

// O(1) - Constant Time
// O(n) - Linear Time
// O(n^2) - Quadratic Time
// O(log n) - Logarithmic Time

// Big-O notation provides an upper bound on the time complexity,
// and this program is a simplification for illustrative purposes. 
// In real-world scenarios, 
// there might be other factors affecting the runtime.

package bigONotationDemo;


public class BigONotationDemo {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// o(1) - Constant Time
		constantTime(arr);
		
		// 0(n) - Linear Time
		linearTime(arr);
		
		// O(n^2) - Quadratic Time
		quadraticTime(arr);
		
		// O(log n) - Logarithmic Time (binary search example)
		boolean found = logarithmicTime(arr, 7);
		System.out.println("Found: " + found);
	
	}
	
	// O(1) - Constant Time
	public static void constantTime(int[] arr) {
		System.out.println("Constant Time O(1): " + arr[0]);
	}
	
	// O(n) = Linear Time
	public static void linearTime(int[] arr) {
		System.out.println("Linear Time O(n):");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	// O(n^2) - Quadratic Time
	public static void quadraticTime(int[] arr) {
		System.out.println("Quadratic Time O(n^2):");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i] + "," + arr[j] + " ");
			}
			System.out.println();
		}
	}
	
	// O(log n) - Logarithmic Time
	public static boolean logarithmicTime(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] < target) {
				return true;
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}

}

// Quadratic Time (O(n^2)):
// Quadratic time complexity describes an algorithm for which the performance is directly proportional
// to the squared size of the input data set.
// This is common with algorithms that involve nested iterations over the data set,
// like our quadraticTime function.
// If you double the number of elements in the data set,
// the number of operations required would increase by a factor of four.

// Understanding the Output:
// The quadraticTime function demonstrates the O(n^2) 
// complexity by having two nested loops that iterate over the same array.
// This means for every item i in the array,
// it loops over every item j in the array.
// So for an array of size 10, there will be 10 x 10 = 100 iterations.

// The output makes it clear that for every value of i,
// there's a full run of values for j — resulting in n x n pairs, which is why it's O(n^2).
