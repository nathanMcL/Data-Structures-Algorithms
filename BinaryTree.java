// This is the basic structure of a binary tree node:
// A new binary tree is instantiated.
// Nodes are created and linked together to form the tree structure.
// The isFullBinaryTree method is called to check if the created tree is a full binary tree.
// Based on the result, an appropriate message is printed to the console.
// That's the entire program in a nutshell! The main logic revolves around the recursive function which checks if the tree is full or not.

class Node {
    int data; // Value to be stored in the node
    Node left, right; // Pointers to the ledt and right child nodes

    public Node(int item) {
        data = item;
        left = right = null; // By default, a new node doesn't have any children
    }
}

public class BinaryTree {
    Node root; // The topmost node of the binary tree

    // Utility function to check if the given binary tree is full or not
    boolean isFullBinayTree(Node node) {
        // If an empty tree
        if (node == null)
            return true;

        // If there is a leaf node
        if (node.left == null && node.right == null)
        return true;
        
        // If Both left and right subtrees are not null, and left and right subtrees are full
        if ((node.left != null) && (node.right != null))
            return (isFullBinayTree(node.left) && isFullBinayTree(node.right));

        // We reach here when none of the above if conditions work
        return false;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node newNode = new Node(1);
        tree.root = newNode;
        tree.root.left = new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        if (tree.isFullBinayTree(tree.root))
            System.out.println("The tree is a full binary tree");
        else
            System.out.println("The tree is not a full binary tree");
    }
    
}
