package kdTreeDemo;

class KDTree {
    private KDNode root;
    private final int k = 2; // For 2-dimensional points

    // Method to insert a point into the tree
    public void insert(Point point) {
        root = insertRec(root, point, 0);
    }

    // Recursive function to insert a new point into the k-d tree
    private KDNode insertRec(KDNode node, Point point, int depth) {
        if (node == null) {
            return new KDNode(point);
        }

        // Calculate current dimension
        int cd = depth % k;

        if (point.coordinates[cd] < node.point.coordinates[cd]) {
            node.left = insertRec(node.left, point, depth + 1);
        } else {
            node.right = insertRec(node.right, point, depth + 1);
        }

        return node;
    }

    // Method to find the nearest neighbor to a given point in the tree
    public Point findNearestNeighbor(Point target) {
        return findNearestRec(root, target, 0, null).point;
    }

    // Recursive function to find the nearest neighbor
    private KDNode findNearestRec(KDNode node, Point target, int depth, KDNode best) {
        if (node == null) {
            return best;
        }

        // Update best if the current node is closer
        if (best == null || node.point.distance(target) < best.point.distance(target)) {
            best = node;
        }

        // Calculate current dimension
        int cd = depth % k;

        KDNode goodSide = node.left;
        KDNode badSide = node.right;
        if (target.coordinates[cd] > node.point.coordinates[cd]) {
            goodSide = node.right;
            badSide = node.left;
        }

        // Explore the good side of the tree
        best = findNearestRec(goodSide, target, depth + 1, best);

        // See if we have to explore the bad side
        if (badSide != null) {
            double radius = target.distance(best.point);
            double splitDistance = Math.abs(target.coordinates[cd] - node.point.coordinates[cd]);
            if (splitDistance < radius) {
                best = findNearestRec(badSide, target, depth + 1, best);
            }
        }

        return best;
    }
}
