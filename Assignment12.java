// Name: Zainab Mohammed
// Assignment:  12-Part-1-Prims

import java.util.*;
class Assignment12 {//Prim's MST
    public static void main(String[] args) {
        Assignment12 prim = new Assignment12();
        //  A  B  C  D  E  F  G  H
        //A{0, 0, 4, 0, 0, 7, 0, 0}
        //B{0, 0, 0, 0, 9, 0, 0, 3}
        //C{4, 0, 0, 3, 0, 2, 9, 0}
        //D{0, 0, 3, 0, 3, 0, 7, 0}
        //E{0, 9, 0, 3, 0, 0, 2, 7}
        //F{7, 0, 2, 0, 0, 0, 8, 0}
        //G{0, 0, 9, 7, 2, 8, 0, 3}
        //H{0, 3, 0, 0, 7, 0, 3, 0}

        //8 by 8 adjacency matrix

        int graph[][] = new int[][]{{0, 0, 4, 0, 0, 7, 0, 0}, {0, 0, 0, 0, 9, 0, 0, 3}, {4, 0, 0, 3, 0, 2, 9, 0},
                {0, 0, 3, 0, 3, 0, 7, 0}, {0, 9, 0, 3, 0, 0, 2, 7}, {7, 0, 2, 0, 0, 0, 8, 0}, {0, 0, 9, 7, 2, 8, 0, 3},
                {0, 3, 0, 0, 7, 0, 3, 0}};
        //A=0,B=1,C=2,D=3,E=4,F=5,G=6,H=7

        int vertexesNum = 8;//the number of vertices in graph

        prim.PrimAlgorithm(graph, vertexesNum);
    }
    public void PrimAlgorithm(int[][] graph, int numOfVertexes) {
        int numOfEdges = 0; // number of edges
        boolean[] vertexIncludedMST = new boolean[numOfVertexes]; // an array to keep track of vertex that were included
//everything in array is already set to false
        vertexIncludedMST[0] = true;  // make the 1st or “0” index true

        HashMap hashMap = new HashMap();
        hashMap.put(0, "A");
        hashMap.put(1, "B");
        hashMap.put(2, "C");
        hashMap.put(3, "D");
        hashMap.put(4, "E");
        hashMap.put(5, "F");
        hashMap.put(6, "G");
        hashMap.put(7, "H");


       // printing edges and weights
        while (numOfEdges < numOfVertexes - 1) {//numOfedges will always be less than vertex-1
            int minimum = 999, row = 0, column = 0; // minimum, row number and colunm number

            for (int i = 0; i < numOfVertexes; i++) {//for every vertex

                if (vertexIncludedMST[i]) {//if the vertex selected at i is true
                    for (int j = 0; j < numOfVertexes; j++) {

                        if (graph[i][j] != 0 && vertexIncludedMST[j]==false) {//if there is an edge that is not part of yhe vertex indlued list of edges
                            if (graph[i][j]<minimum) {//if minimum is less than the graph [i][j] then
                                minimum = graph[i][j];//make the minimum the graph at [i][j]

                                column = j;
                                row = i;

                            }
                        }
                    }
                }
            }
            System.out.println(hashMap.get(row) + " --> " + hashMap.get(column) + " --weight--> " + graph[row][column]);
            vertexIncludedMST[column] = true;

            ++numOfEdges;
        }
    }


}
