// Chpt: 4, pg 140, 4-4
// Assume that we are given n pairs of items as input,
// where the first item is a number and the second item is one of three colors (red, blue, green).
// Further, assume that the items are sorted by number.
// Provide an O(n) algorithm to sort the items by color
// (all reds before all blues before all yellows) such that the numbers for identical colors stay sorted


// First, separate the items into three categories according to their colors
// Second, within each color group, the items should already be sorted by number due to the given condition

import java.util.*;

// Define a class to represent a colored number, consisting of an integer and a color.
class ColoredNumber {
    int number;
    String color;

    // Constructor to initialize the number and color.
    ColoredNumber(int number, String color) {
        this.number = number;
        this.color = color;
    }

    // Still not sure about Overrides...this overrides the toString method to print the ColoredNumber in a readable format.
    @Override
    public String toString() {
        return "(" + number + ", " + color + ")";
    }
}

public class ColorSorter {

    // Method to sor the array of ColoredNumber items by color
    public static void sortByColor(ColoredNumber[] items) {
        List<ColoredNumber> reds = new LinkedList<>();
        List<ColoredNumber> blues = new LinkedList<>();
        List<ColoredNumber> greens = new LinkedList<>();

        // O(n) Separate items by color
        // Iterate through all items and add them to the appropriate list based on their color.
        for (ColoredNumber item : items) {
            switch (item.color) {
                case "red":
                    reds.add(item);
                    break;
                case "blue":
                    blues.add(item);
                    break;
                case "green":
                    greens.add(item);
                    break;
            }
        }
        
        // O(n) - Combine the lists: reds -> blues -> greens
        int index = 0;
        for (ColoredNumber red : reds) items[index++] = red;
        for (ColoredNumber blue : blues) items[index++] = blue;
        for (ColoredNumber green : greens) items[index++] = green;
    }

    public static void main(String[] args) {
        ColoredNumber[] items = {
                new ColoredNumber(5, "green"),
                new ColoredNumber(3, "red"),
                new ColoredNumber(8, "blue"),
                new ColoredNumber(1, "green"),
                new ColoredNumber(3, "blue"),
                new ColoredNumber(2, "red"),
                new ColoredNumber(4, "blue"),
                new ColoredNumber(9, "green"),
                new ColoredNumber(2, "blue"),
                new ColoredNumber(0, "red")
        };

        sortByColor(items);

        // Output the sorted by color items
        System.out.println(Arrays.toString(items));
    }
}
