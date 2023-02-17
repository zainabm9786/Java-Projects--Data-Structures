import java.io.*;
import java.util.*;

public class PP7WeightedGraphs {
    public static void main(String[] args) throws IOException {
        /*Scanner sc = new Scanner(System.in);
        ArrayList<Integer> verticesArrayList = new ArrayList<>();
        System.out.println("Enter name of file: ");//Your program should prompt the user to enter the name of the file
        String filename = sc.nextLine();
        Scanner reader = new Scanner(new File(filename));
        int numberOfVertices = 0;
        int i = 0;
        ArrayList<WeightedEdge> edgeArrayList = new ArrayList<>();
        String [] array=new String[3];
        while ((reader.hasNextLine())){//read data from the file
            if (i == 0) {// Read the first line to get the number of vertices.
                numberOfVertices = Integer.parseInt(reader.nextLine());//takes the firs tline and makes it the vertices
            i++;
            }
            else {
               String s = reader.nextLine();
            *//*    String[] triple= s.split("\\|,");
                for (int x=0;x<triple.length;x++){
                    triple[x]
                }*//*
                s = s.replaceAll("\\|", "");
                s = s.replaceAll(",", "");

                Scanner vertexx = new Scanner(s);
                while (vertexx.nextLine()!=null) {
                    int u = vertexx.nextInt();

                    int v = vertexx.nextInt();


                    long weight = vertexx.nextLong();
                    edgeArrayList.add(new WeightedEdge(u, v, weight));
                    edgeArrayList.add(new WeightedEdge(v, u, weight));
                    vertexx.nextLine();
                }
                System.out.println(reader.nextLine());
                i++;
                vertexx.close();
            }
        }
        reader.close();
        System.out.println("The number of vertices is "+numberOfVertices);

        WeightedGraph weightedGraph = new WeightedGraph(edgeArrayList, verticesArrayList);//create an instance g of WeightedGraph
        weightedGraph.printWeightedEdges();//nvoke g.printWeightedEdges() to display all edges
        WeightedGraph<Integer>.MST tree = weightedGraph.getMinimumSpanningTree();// invoke getMinimumSpanningTree() to obtain an instance tree of WeightedGraph.MST
        System.out.println("Total weight is " + tree.getTotalWeight());// invoke tree.getTotalWeight() to display the weight of the minimum spanning tree
        tree.printTree();// invoke tree.printTree() to display the tree*/
      /*  Integer[] vertices = {0, 1, 2, 3, 4};

        int[][] edges = {
                {0, 1}, {0, 2},
                {1, 0}, {1, 2}, {1, 3}, {1, 4},
                {2, 0}, {2, 1}, {2, 3},
                {3, 1}, {3, 2}, {3, 4},
                {4, 1}, {4, 3}
        };

        Graph<Integer> graph1 = new UnweightedGraph<>(vertices, edges);
        AbstractGraph<Integer>.Tree dfs = graph1.dfs(0);
        System.out.println(dfs.getPath(4));*/
        Integer[] vertices = {0, 1, 2, 3, 4};

        int[][] edges = {
                {0, 1, 9}, {0, 2, 5},
                {1, 0, 9}, {1, 2, 6}, {1, 3, 4}, {1, 4, 7},
                {2, 0, 5}, {2, 1, 6}, {2, 3, 3},
                {3, 1, 4}, {3, 2, 3}, {3, 4, 1},
                {4, 1, 7}, {4, 3, 1}
        };

        WeightedGraph<Integer> graph1 =
                new WeightedGraph<>(vertices, edges);
        WeightedGraph<Integer>.ShortestPathTree tree1 =
                graph1.getShortestPath(graph1.getIndex(0));

        System.out.println("Shortest path from 4 to 0 is " +
                tree1.getPath(4));
    }
}
class WeightedEdge extends AbstractGraph.Edge
        implements Comparable<WeightedEdge> {
    public double weight; // The weight on edge (u, v)

    /** Create a weighted edge on (u, v) */
    public WeightedEdge(int u, int v, double weight) {
        super(u, v);
        this.weight = weight;
    }

    /** Compare two edges on weights */
    public int compareTo(WeightedEdge edge) {
        if (weight > edge.weight) {
            return 1;
        }
        else if (weight == edge.weight) {
            return 0;
        }
        else {
            return -1;
        }
    }
}
class WeightedGraph<V> extends AbstractGraph<V> {
    /**
     * Construct an empty
     */
    public WeightedGraph() {
    }

    /**
     * Construct a WeightedGraph from vertices and edged in arrays
     */
    public WeightedGraph(V[] vertices, int[][] edges) {
        createWeightedGraph(java.util.Arrays.asList(vertices), edges);
    }

    /**
     * Construct a WeightedGraph from vertices and edges in list
     */
    public WeightedGraph(int[][] edges, int numberOfVertices) {
        List<V> vertices = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++)
            vertices.add((V) (new Integer(i)));

        createWeightedGraph(vertices, edges);
    }

    /**
     * Construct a WeightedGraph for vertices 0, 1, 2 and edge list
     */
    public WeightedGraph(List<V> vertices, List<WeightedEdge> edges) {
        createWeightedGraph(vertices, edges);
    }

    /**
     * Construct a WeightedGraph from vertices 0, 1, and edge array
     */
    public WeightedGraph(List<WeightedEdge> edges,
                         int numberOfVertices) {
        List<V> vertices = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++)
            vertices.add((V) (new Integer(i)));

        createWeightedGraph(vertices, edges);
    }

    /**
     * Create adjacency lists from edge arrays
     */
    private void createWeightedGraph(List<V> vertices, int[][] edges) {
        this.vertices = vertices;

        for (int i = 0; i < vertices.size(); i++) {
            neighbors.add(new ArrayList<Edge>()); // Create a list for vertices
        }

        for (int i = 0; i < edges.length; i++) {
            neighbors.get(edges[i][0]).add(
                    new WeightedEdge(edges[i][0], edges[i][1], edges[i][2]));
        }
    }

    /**
     * Create adjacency lists from edge lists
     */
    private void createWeightedGraph(
            List<V> vertices, List<WeightedEdge> edges) {
        this.vertices = vertices;

        for (int i = 0; i < vertices.size(); i++) {
            neighbors.add(new ArrayList<Edge>()); // Create a list for vertices
        }

        for (WeightedEdge edge : edges) {
            neighbors.get(edge.u).add(edge); // Add an edge into the list
        }
    }

    /**
     * Return the weight on the edge (u, v)
     */
    public double getWeight(int u, int v) throws Exception {
        for (Edge edge : neighbors.get(u)) {
            if (edge.v == v) {
                return ((WeightedEdge) edge).weight;
            }
        }

        throw new Exception("Edge does not exit");
    }

    /**
     * Display edges with weights
     */
    public void printWeightedEdges() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(getVertex(i) + " (" + i + "): ");
            for (Edge edge : neighbors.get(i)) {
                System.out.print("(" + edge.u +
                        ", " + edge.v + ", " + ((WeightedEdge) edge).weight + ") ");
            }
            System.out.println();
        }
    }

    /**
     * Add edges to the weighted graph
     */
    public boolean addEdge(int u, int v, double weight) {
        return addEdge(new WeightedEdge(u, v, weight));
    }

    /**
     * Get a minimum spanning tree rooted at vertex 0
     */
    public MST getMinimumSpanningTree() {
        return getMinimumSpanningTree(0);
    }

    /**
     * Get a minimum spanning tree rooted at a specified vertex
     */
    public MST getMinimumSpanningTree(int startingVertex) {
        // cost[v] stores the cost by adding v to the tree
        double[] cost = new double[getSize()];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Double.POSITIVE_INFINITY; // Initial cost
        }
        cost[startingVertex] = 0; // Cost of source is 0

        int[] parent = new int[getSize()]; // Parent of a vertex
        parent[startingVertex] = -1; // startingVertex is the root
        double totalWeight = 0; // Total weight of the tree thus far

        List<Integer> T = new ArrayList<>();

        // Expand T
        while (T.size() < getSize()) {
            // Find smallest cost v in V - T
            int u = -1; // Vertex to be determined
            double currentMinCost = Double.POSITIVE_INFINITY;
            for (int i = 0; i < getSize(); i++) {
                if (!T.contains(i) && cost[i] < currentMinCost) {
                    currentMinCost = cost[i];
                    u = i;
                }
            }

            T.add(u); // Add a new vertex to T
            totalWeight += cost[u]; // Add cost[u] to the tree

            // Adjust cost[v] for v that is adjacent to u and v in V - T
            for (Edge e : neighbors.get(u)) {
                if (!T.contains(e.v) && cost[e.v] > ((WeightedEdge) e).weight) {
                    cost[e.v] = ((WeightedEdge) e).weight;
                    parent[e.v] = u;
                }
            }
        } // End of while

        return new MST(startingVertex, parent, T, totalWeight);
    }

    /**
     * MST is an inner class in WeightedGraph
     */
    public class MST extends Tree {
        private double totalWeight; // Total weight of all edges in the tree

        public MST(int root, int[] parent, List<Integer> searchOrder,
                   double totalWeight) {
            super(root, parent, searchOrder);
            this.totalWeight = totalWeight;
        }

        public double getTotalWeight() {
            return totalWeight;
        }
    }

    /**
     * Find single source shortest paths
     */
    public ShortestPathTree getShortestPath(int sourceVertex) {
        // cost[v] stores the cost of the path from v to the source
        double[] cost = new double[getSize()];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Double.POSITIVE_INFINITY; // Initial cost set to infinity
        }
        cost[sourceVertex] = 0; // Cost of source is 0

        // parent[v] stores the previous vertex of v in the path
        int[] parent = new int[getSize()];
        parent[sourceVertex] = -1; // The parent of source is set to -1

        // T stores the vertices whose path found so far
        List<Integer> T = new ArrayList<>();

        // Expand T
        while (T.size() < getSize()) {
            // Find smallest cost v in V - T
            int u = -1; // Vertex to be determined
            double currentMinCost = Double.POSITIVE_INFINITY;
            for (int i = 0; i < getSize(); i++) {
                if (!T.contains(i) && cost[i] < currentMinCost) {
                    currentMinCost = cost[i];
                    u = i;
                }
            }

            T.add(u); // Add a new vertex to T

            // Adjust cost[v] for v that is adjacent to u and v in V - T
            for (Edge e : neighbors.get(u)) {
                if (!T.contains(e.v)
                        && cost[e.v] > cost[u] + ((WeightedEdge) e).weight) {
                    cost[e.v] = cost[u] + ((WeightedEdge) e).weight;
                    parent[e.v] = u;
                }
            }
        } // End of while

        // Create a ShortestPathTree
        return new ShortestPathTree(sourceVertex, parent, T, cost);
    }

    /**
     * ShortestPathTree is an inner class in WeightedGraph
     */
    public class ShortestPathTree extends Tree {
        private double[] cost; // cost[v] is the cost from v to source

        /**
         * Construct a path
         */
        public ShortestPathTree(int source, int[] parent,
                                List<Integer> searchOrder, double[] cost) {
            super(source, parent, searchOrder);
            this.cost = cost;
        }

        /**
         * Return the cost for a path from the root to vertex v
         */
        public double getCost(int v) {
            return cost[v];
        }

        /**
         * Print paths from all vertices to the source
         */
        public void printAllPaths() {
            System.out.println("All shortest paths from " +
                    vertices.get(getRoot()) + " are:");
            for (int i = 0; i < cost.length; i++) {
                printPath(i); // Print a path from i to the source
                System.out.println("(cost: " + cost[i] + ")"); // Path cost
            }
        }
    }
}
