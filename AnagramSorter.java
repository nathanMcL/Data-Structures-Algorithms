// Chapter 10: Sorting and Searching
// pp. 146-149
// Problem 10.2

// Group Anagrams: Write a method to sort an array of strings so that all the anagrams are next to each other

import java.util.*;

public class AnagramSorter {
    public static void main(String[] args) {
        String[] sillyWords = {
            "tacocat", "cattaco", "dormotory", "dirty room",
            "rail", "liar", "cat", "act"
        };
        
        // Sort the words such that anagrams are next to each other
        String[] sortedArray = sortAnagrams(sillyWords);

        // Print out the sorted array or words
        for (String word : sortedArray) {
            System.out.println(word);
        }
    }

    public static String[] sortAnagrams(String[] words) {
        // HashMap to store lists of anagrams
        // The key is the sorted version of the word
        // The value is a list of words that are anagrams of the key
        Map<String, List<String>> anagramMap = new HashMap<>();

        // Loop through each word in the provided array
        for (String word : words) {
            // Convert the word to a character array ad sort the array,
            // This sorted version will act as the key in the map
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            // Add the original word to the map
            // 
            anagramMap
            .computeIfAbsent(sortedWord, k -> new ArrayList<>())
            .add(word);
        
        }

        // Next Convert the lists of anagrams in the map into a single list
        List<String> sortedList = new ArrayList<>();
        for (List<String> group : anagramMap.values()) {
            sortedList.addAll(group);
        }

        // Convert the list of anagrams into an array and return the array
        return sortedList.toArray(new String[0]);
    }
    
}
