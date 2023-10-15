// A heap is a special type of data structure that is a complete binary tree.
// This means that all internal nodes have two children,
// and all the leaves are at the same level.
// Heaps are typically used to implement priority queues, 
// which are data structures that allow you to efficiently add, remove,
// and find the largest or smallest element.

// There are two types of heaps: max heaps and min heaps. In a max heap,
// the parent node is always greater than or equal to its children.
// In a min heap, the parent node is always less than or equal to its children.

// Here is my example of a mini heap.

public class MinHeap {
    private int[] heap;
    private int size;
    private int maxsize;

    // Constructor to initialize an empty min heap with given maximum capacity
    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[this.maxsize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }

    private void swap(int fpos, int spos) {
        int tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    // Function to heapify the node at pos
    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    // Fuction to insert a node into the heap
    public void insert(int element) {
        if (size >= maxsize) {
            return;
        }
        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Function to remove and return the minimum element from the heap
    public int remove() {
        int popped = heap[1];
        heap[1] = heap[size--];
        minHeapify(1);
        return popped;
    }

    public static void main(String[] arg) {
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        System.out.println("The min value is: " + minHeap.remove());
    }
}