// Chapter 4,pg: 109, Q: 4.1
// Find a route between two nodes in a directed graph,
// you can use Breadth-First Search (BFS)

// The isReachable method checks if there's a path from source node s to target node t. 
// The BFS traversal marks each visited node and checks if the target node t has been reached.
// If it's reached, the method returns true; otherwise, 
// it returns false after all nodes have been explored.

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Returns true if there is a path from source 's' to target 't'
    boolean isReachable(int s, int t) {
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue
            s = queue.poll();

            // Get all adjacent vertices of the dequeued vertex
            for (Integer neighbor : adj[s]) {
                if (neighbor == t) {
                    return true;
                }

                // Mark the neighbor as visited and enqueue it
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        // If BFS is complete without visiting t
        return false;
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        int u = 1;
        int v = 3;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u + " to " + v);
        else
            System.out.println("There is no path from " + u + " to " + v);;
    }
}
