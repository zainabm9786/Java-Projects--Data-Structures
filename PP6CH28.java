import java.util.*;

public class PP6CH28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
                "Denver", "Kansas City", "Chicago", "Boston", "New York",
                "Atlanta", "Miami", "Dallas", "Houston"};

        int[][] edges = {
                {0, 1}, {0, 3}, {0, 5},
                {1, 0}, {1, 2}, {1, 3},
                {2, 1}, {2, 3}, {2, 4}, {2, 10},
                {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
                {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
                {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
                {6, 5}, {6, 7},
                {7, 4}, {7, 5}, {7, 6}, {7, 8},
                {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
                {9, 8}, {9, 11},
                {10, 2}, {10, 4}, {10, 8}, {10, 11},
                {11, 8}, {11, 9}, {11, 10}
        };

        int adjMatrix [][] = new int[vertices.length][vertices.length];
        for (int[] row : adjMatrix) {
            Arrays.fill(row, 0);
        }
        for (int i = 0; i < edges.length; i++) {
            adjMatrix[edges[i][1]][edges[i][0]] = 1;
            adjMatrix[edges[i][0]][edges[i][1]] = 1;

        }
        System.out.println("Adjacency Matrix: ");
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        for (int i=0;i<5;i++) {
            System.out.println("\nEnter vertex number: ");
            int num = sc.nextInt();
            System.out.println("Number of vertices in the graph is: " + vertices.length);
            System.out.println("The vertex with index " + num + " is: " + vertices[num]);
        }
    }
}