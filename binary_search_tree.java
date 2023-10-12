//Chapter 4 pg: 110, Question 4.5 Validate a BST

//  Use a recursive helper function with minimum and maximum range
// values that checks if the current node's value lies within the specified range.


public class binary_search_tree {
    int val;
    binary_search_tree left;
    binary_search_tree right;
    binary_search_tree(int x) { val = x; }


public boolean isValidBST(binary_search_tree root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

private boolean isValidBST(binary_search_tree node, long min, long max) {
    if (node == null) {
        return true;
    }

    if (node.val <= min || node.val >= max) {
        return false;
    }

    return isValidBST(node.left, min, node.val) && 
           isValidBST(node.right, node.val, max);
}
}
