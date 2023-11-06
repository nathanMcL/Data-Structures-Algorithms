// https://en.wikipedia.org/wiki/K-d_tree
// A 3-dimensional k-d tree. The first split (the red vertical plane) cuts the root cell (white) into two subcells,
// each of which is then split (by the green horizontal planes) into two subcells.
// Finally, four cells are split (by the four blue vertical planes) into two subcells.
// Since there is no more splitting, the final eight are called leaf cells.

package kdTreeDemo;

public class Main {
    public static void main(String[] args) {
        // Create a KDTree instance
        KDTree tree = new KDTree();

        // Insert points into the KDTree
        tree.insert(new Point(3, 6));
        tree.insert(new Point(17, 15));
        tree.insert(new Point(13, 15));
        tree.insert(new Point(15, 25));
        tree.insert(new Point(20, 25));
        tree.insert(new Point(23, 35));
        tree.insert(new Point(27, 35));


        // Find the nearest neighbor to a given point
        Point target = new Point(10, 19);
        Point nearest = tree.findNearestNeighbor(target);

        System.out.println("The nearest neighbor to (" + target.coordinates[0] + ", " +
                target.coordinates[1] + ") is (" + nearest.coordinates[0] + ", " +
                nearest.coordinates[1] + ")");
    }
}

