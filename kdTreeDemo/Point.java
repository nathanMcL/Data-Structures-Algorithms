package kdTreeDemo;

class Point {
    double[] coordinates;

    Point(double x, double y) {
        this.coordinates = new double[]{x, y};
    }

    double distance(Point other) {
        double sum = 0;
        for (int i = 0; i < this.coordinates.length; i++) {
            sum += Math.pow(this.coordinates[i] - other.coordinates[i], 2);
        }
        return Math.sqrt(sum);
    }
}

class KDNode {
    Point point;
    KDNode left, right;

    KDNode(Point point) {
        this.point = point;
    }
}
