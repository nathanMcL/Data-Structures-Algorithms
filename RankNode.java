// Chapter 10: Sorting and Searching
// p. 146-149
// Problem 10.10

// Imagine you are reading in a stream of integers. Periodically, you wish to be able to look up the rank of a number x 
// ( the number of values less than or equal to x). 
// Implement the data structures and algorithms to support these operations.
// That is implemented in the method track(int x),
// which is called when each number is generated, and the method getRankOfNumber(int x),
// which returns the number of values less than or equal to x (not including x itself)

//  Solving this challenge, we have to use a binary search tree(BST)
// Create additioanl fields in each node
// The size of each subtree rooted at that node, this will help to compute
// The rank of a number in O(log n)time, if the tree were balanced.

// Node class for the binary search tree.
class RankNode {
    // Number of nodes in the left subtree.
    public int left_size = 0;
    
    // Left child node.
    public RankNode left;
    
    // Right child node.
    public RankNode right;
    
    // Value/data held by the node.
    public int data = 0;

    // Constructor: initializes the node with given data.
    public RankNode(int d) {
        data = d;
    }

    // Inserts a new value into the subtree rooted at this node.
    public void insert(int d) {
        // If the value to insert is less than or equal to current node's data.
        if (d <= data) {
            // Insert into left subtree if left child exists.
            if (left != null) {
                left.insert(d);
            } else { 
                // Otherwise, create a new left child node with the given value.
                left = new RankNode(d);
            }
            // Increment the size of left subtree.
            left_size++;
        } else {
            // If the value to insert is greater than current node's data.
            // Insert into right subtree if right child exists.
            if (right != null) {
                right.insert(d);
            } else { 
                // Otherwise, create a new right child node with the given value.
                right = new RankNode(d);
            }
        }
    }

    // Gets the rank of a number in the subtree rooted at this node.
    public int getRank(int d) {
        // If the value is found at the current node, return size of left subtree.
        if (d == data) {
            return left_size;
        } else if (d < data) {
            // If the value is less than current node's data, search in left subtree.
            if (left == null) {
                return -1;
            } else {
                return left.getRank(d);
            }
        } else {
            // If the value is greater than current node's data, search in right subtree.
            int right_rank = right == null ? -1 : right.getRank(d);
            
            // If the value was not found in right subtree, return -1.
            // Otherwise, return size of left subtree + 1 (for current node) + rank from right subtree.
            return right_rank == -1 ? -1 : left_size + 1 + right_rank;
        }
    }
}

// Class to track the rank of numbers.
public class RankTracker {
    // Root node of the BST.
    RankNode root = null;

    // Inserts a number into the tree.
    public void track(int number) {
        if (root == null) {
            // If the tree is empty, create a new root node.
            root = new RankNode(number);
        } else {
            // Otherwise, insert the number starting from the root.
            root.insert(number);
        }
    }

    // Returns the rank of a number.
    public int getRankOfNumber(int number) {
        return root.getRank(number);
    }

    // Main method for testing purposes.
    public static void main(String[] args) {
        RankTracker tracker = new RankTracker();
        
        // Array of numbers to insert into the tracker.
        int[] arr = {5, 1, 4, 4, 5, 9, 7, 13, 3};
        for (int i : arr) {
            tracker.track(i);
        }

        // Test and print the rank of numbers.
        System.out.println(tracker.getRankOfNumber(1)); // 0
        System.out.println(tracker.getRankOfNumber(3)); // 1
        System.out.println(tracker.getRankOfNumber(4)); // 3
    }
}
