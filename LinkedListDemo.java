import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {

        // 1. Create a linked list of  integers
        LinkedList<Integer> list = new LinkedList<Integer>();

        // 2. Add elements to the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("Linked List after adding elements: " + list);

        // 3. Remove an element from the list
        list.remove(new Integer(30)); // Remove the value 30

        System.out.println("Linked List after removing 30: " + list);

        // 4. Traverse the list to display the elements
        System.out.print("Elements in the linked list: ");
        for (int value : list) {
            System.out.print(value + " ");
        }

    }
}