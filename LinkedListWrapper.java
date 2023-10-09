import java.util.LinkedList;

public class LinkedListWrapper<T> {
    private LinkedList<T> list;

    public LinkedListWrapper() {
        list = new LinkedList<>();
    }

    // Add element to the end of the list
    public void add(T data) {
        list.add(data);
    }

    // Insert element at a specific position
    public void addAt(int index, T data) {
        list.add(index, data);
    }

    // Remove element from a specific position
    public T removeAt(int index) {
        return list.remove(index);
    }

    // Find first occurrence of a data and remove it
    public boolean remove(T data) {
        return list.remove(data);
    }

    // Check if list contails a data
    public boolean contains(T data) {
        return list.contains(data); 
    }

    // Print the list
    public void printList() {
        for (T data : list) {
            System.out.print(data + " -> ");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListWrapper<Integer> listWrapper = new LinkedListWrapper<>();
        listWrapper.add(10);
        listWrapper.add(20);
        listWrapper.add(30);

        System.out.println("Initial list:");
        listWrapper.printList();

        listWrapper.addAt(2, 25);
        System.out.println("\nList after insertin 25 at index 2:");
        listWrapper.printList();

        listWrapper.remove(20);
        System.out.println("\nList after removing 20:");
        listWrapper.printList();
    }
    
}
