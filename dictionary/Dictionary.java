// The Algorithm Design Manual (Skiena), the red book
// Chpt 3, pg 104 3-11
// Trees and otherDictionary structures

// The map keeps track of the key and its index in the list.
// The list helps in keeping track of the order in which the keys are inserted.
// When inserting, we simply add the key to the list and update its index in the map.
// When deleting, we swap the last key in the list with the key to be deleted. 
// This allows for constant time deletion.
// The search just checks if the key is in the map.
// This implementation ensures average O(1) time complexity for insertion, deletion, and search operations.

// The HashMap will allow O(1) average time complexity for search, insertion, and removal, 
// while the ArrayList will be used to keep track of the keys for O(1) time complexity removal 
// (since ArrayList provides O(1) time complexity for removal at index).

package dictionary;

import java.util.*;

public class Dictionary {
	
	private Map<Integer, Integer> map; // Maps key to its index in the list
	private List<Integer> list; // List of keys
	
	public Dictionary(int n) {
		map = new HashMap<>();
		list = new ArrayList<>();
	}
	
	// Inserts a key into the dictionary
	public void insert(int key) {
		if (!map.containsKey(key)) {
			list.add(key);
			map.put(key,  list.size() - 1);
		}
	}
	
	// Deletes a key from the dictionary
	public void delete(int key) {
		if (map.containsKey(key)) {
			int index = map.get(key);
			int lastElement = list.get(list.size() - 1);
			
			// Move the last element to the index of the key to be removed
			list.set(index, lastElement);
			map.put(lastElement, index);
			
			// Remove the last element from the list
			list.remove(list.size() - 1);
			map.remove(key);
		}
	}
	
	// Searches for a key in the dictionary
	public boolean search(int key) {
		return map.containsKey(key);
	}
	

	public static void main(String[] args) {
		Dictionary dict = new Dictionary(5);
		
		dict.insert(1);
		dict.insert(2);
		dict.insert(3);
		
		System.out.println(dict.search(1)); // True
		System.out.println(dict.search(4)); // False
		
		dict.delete(2);
		
		System.out.print(dict.search(2)); // False

	}

}
