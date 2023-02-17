// Name:		Zainab Mohammed
// Assignment:  11-Part-1-DFS

import java.util.*;

public class DFS {
    public static void main(String[] args) {

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
        Graph<String> graph = new UnweightedGraphWithNonrecursiveDFS<>(vertices, edges);
        AbstractGraph<String>.Tree dfs = graph.dfs(graph.getIndex("Chicago"));

        java.util.List<Integer> searchOrders = dfs.getSearchOrder();

        System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
        for (int i = 0; i < searchOrders.size(); i++)
            System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
        System.out.println();

        for (int i = 0; i < searchOrders.size(); i++)
            if (dfs.getParent(i) != -1)
                System.out.println("parent of " + graph.getVertex(i) +
                        " is " + graph.getVertex(dfs.getParent(i)));
    }

}

class UnweightedGraphWithNonrecursiveDFS <V> extends UnweightedGraph {
   public UnweightedGraphWithNonrecursiveDFS(V[] vertices, int[][] edges) {
       super(vertices, edges);
   }
    @Override
    public Tree dfs(int v) {//i am assuming v is the first node we will look at

        int[] parent = new int[vertices.size()];//keeps track of values above it
        boolean alreadyVisited[] = new boolean[vertices.size()];//array to keep track of the already visited numbers so things are not repreated
        Stack<Integer> integerStack = new Stack<>();//creates a stack which i will use to put numbers in and then pop
        integerStack.push(v);//adds first element that is sent in to the stack
        List<Integer> list;
        List<Integer> searchOrder = new ArrayList<>();
        while (!integerStack.isEmpty()) {//while stack is not empty
            int curr = integerStack.pop();//pops the elemnts on the top of the stack for the first element v, this will just put it into the alraydyVIsitied array

            if (alreadyVisited[curr] == false) {//if the elemnt is not in the already vitied array
                alreadyVisited[curr] = true;//then add it to the already visited array to know that it visited it already
                //visit the current elemnt
                searchOrder.add(curr);
                list = getNeighbors(curr);

                for (int i = 0; i < list.size(); i++) {//neighbors
                    parent[list.get(i)]=curr;
                    if (!alreadyVisited[list.get(i)]) {//if it not visited
                        integerStack.push(list.get(i));//pushed the integer to stack

                    }
                }


            }

        }

        return new Tree(v, parent, searchOrder);
    }
}
