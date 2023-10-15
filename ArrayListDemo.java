// Creation: Initializes an empty ArrayList.
// Addition: Adds elements to the ArrayList.
// Removal: Removes elements from the ArrayList both by value and by index.
// Access: Retrieves elements from the ArrayList by their index.
// Modification: Modifies an element in the ArrayList by its index.
// Search: Checks if the ArrayList contains a specific element.
// Size: Determines the number of elements in the ArrayList.
// Iteration: Loops through each element of the ArrayList.
// Clear: Removes all elements from the ArrayList.

// This demo uses the CRUD theory.
// C (Create) is adding new elements to the list.
// R (Read) is accessing or checking the elements of the list.
// U (Update) is modifying existing elements.
// D (Delete) is removing elements from the list.


import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {
        
        // Create an ArrayList of integers       
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add elements to the ArrayList
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        // Print the entire ArrayList
        System.out.println("Initial ArrayList: " + numbers);

        // Remove an element from the ArrayList
        numbers.remove(new Integer(30));  // Removing the Integer value 30
        System.out.println("After removing 30: " + numbers);

        // Get an element by index
        int value = numbers.get(1);
        System.out.println("Element at index 1: " + value);

        // Modify an element by index
        numbers.set(1, 25);
        System.out.println("After updating index 1: " + numbers);

        // Check if ArrayList contains a specific value
        boolean contains20 = numbers.contains(20);
        System.out.println("Contains 20? " + contains20);

        // Size of the ArrayList
        int size = numbers.size();
        System.out.println("Size of ArrayList: " + size);

        // Loop over elements of the ArrayList
        System.out.print("Using for-each loop: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Clear all elements from the ArrayList
        numbers.clear();
        System.out.println("After clearing: " + numbers);
    }
}

