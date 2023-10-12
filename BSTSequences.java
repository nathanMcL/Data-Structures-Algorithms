// Considering a Binary Search Tree sequence,
// Traverse through an array from left to right
// print all possible arrays that could lead to this tree
// "recursively weaving" refers to the process of intertwining two lists in all possible orders,
//  maintaining the relative ordering of individual elements within each list.

import java.util.*;

// Define the basic structure of a binary tree node
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

public class BSTSequences {
    private Node root;

    // Insert a new value into the BST
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // Recursive helper function to insert a new value
    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);  // If the tree/subtree is empty, create a new node
        }
        // Navigate left or right based on the value being inserted
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Retrieve all possible sequences that could lead to the current BST structure
    public List<List<Integer>> getAllSequences() {
        return getAllSequencesRec(root);
    }

    // Recursive function to retrieve sequences
    private List<List<Integer>> getAllSequencesRec(Node node) {
        if (node == null) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result; // Return an empty list if current node is null
        }

        // Get possible sequences from left and right subtrees
        List<List<Integer>> leftSeq = getAllSequencesRec(node.left);
        List<List<Integer>> rightSeq = getAllSequencesRec(node.right);

        List<List<Integer>> result = new ArrayList<>();

        // Weave together the left and right sequences in all possible ways
        for (List<Integer> left : leftSeq) {
            for (List<Integer> right : rightSeq) {
                List<List<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, new ArrayList<>(), node.data);
                result.addAll(weaved);
            }
        }

        return result;
    }

    // Weave together two lists in all possible ways
    private void weaveLists(List<Integer> first, List<Integer> second, List<List<Integer>> results, List<Integer> prefix, int rootValue) {
        // If one of the lists is empty, add the remaining items to the prefix and store result
        if (first.isEmpty() || second.isEmpty()) {
            List<Integer> clone = new ArrayList<>(prefix);
            clone.add(rootValue);
            clone.addAll(first);
            clone.addAll(second);
            results.add(clone);
            return;
        }

        // Recursively weave with the value from the first list added to the prefix
        prefix.add(rootValue);
        prefix.add(first.remove(0));
        weaveLists(first, second, results, prefix, rootValue);
        first.add(0, prefix.remove(prefix.size() - 1));

        // Recursively weave with the value from the second list added to the prefix
        prefix.add(second.remove(0));
        weaveLists(first, second, results, prefix, rootValue);
        second.add(0, prefix.remove(prefix.size() - 1));
        prefix.remove(prefix.size() - 1);
    }

    
    public static void main(String[] args) {
        BSTSequences tree = new BSTSequences();
        int[] array = {4, 2, 6, 1, 3, 5, 7};
        for (int value : array) {
            tree.insert(value); // Insert values into the BST
        }
        List<List<Integer>> sequences = tree.getAllSequences();
        for (List<Integer> seq : sequences) {
            System.out.println(seq); // Print all possible sequences
        }
    }
}
