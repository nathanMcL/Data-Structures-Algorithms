// The Algorithm Design Manual (Skiena), the red book
// Chpt 3, pg 104 3-12
// Trees and other Dictionary structures

// Give an O(n) algorithm to find the maximum depth of a binary tree with nodes.

// The maximum depth (or height) of a binary tree can be found using a simple recursive algorithm. 
// Starting at the root, you can traverse down each child recursively and keep a count of the depth. 
// The base case would be when you reach a leaf node, where the depth is 1.
// The maximum depth of a node is 1 plus the maximum of the depths of its left and right children.

// This algorithm runs in O(n) time since it traverses each node in the tree exactly once. 
// The recursion essentially performs a depth-first search on the tree,
// calculating the depth for each node.

package treeNode;

//Define a TreeNode class representing a node in the binary tree.
class TreeNode {
 // Each node contains data, a left child, and a right child.
 int data;
 TreeNode left, right;

 // Constructor for the TreeNode.
 public TreeNode(int item) {
     data = item; // Initialize the data with the provided item.
     left = right = null; // By default, left and right children are set to null.
 }
}

//Define a BinaryTree class that will use the TreeNode structure.
class BinaryTree {
 TreeNode root; // This is the root node of the binary tree.

 // Method to find the maximum depth (or height) of the tree.
 public int maxDepth(TreeNode node) {
     // Base case: If the node is null, its depth is 0.
     if (node == null) {
         return 0;
     } else {
         // Recursively calculate the depth of the left subtree.
         int leftDepth = maxDepth(node.left);
         
         // Recursively calculate the depth of the right subtree.
         int rightDepth = maxDepth(node.right);

         // Return the larger of the two depths + 1 (to account for the current node).
         return Math.max(leftDepth, rightDepth) + 1;
     }
 }

 // Main method to test the maxDepth function.
 public static void main(String[] args) {
     // Create a new binary tree.
     BinaryTree tree = new BinaryTree();

     // Manually construct the tree structure.
     tree.root = new TreeNode(1);
     tree.root.left = new TreeNode(2);
     tree.root.right = new TreeNode(3);
     tree.root.left.left = new TreeNode(4);
     tree.root.left.left.left = new TreeNode(5);

     // Print out the height of the tree.
     System.out.println("Height of tree is : " + tree.maxDepth(tree.root));
 }
}


