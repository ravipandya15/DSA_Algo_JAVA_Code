package Graph;

import java.util.ArrayList;

public class Representation_and_Storing_Of_DSA_And_Graph {
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int n = 3;
        // int m = 3;


        // 1st way -> using Adjecency Matrix
        int[][] adj = new int[n + 1][n + 1];


        adj[1][3] = 1;
        adj[2][1] = 1;

        // 2nd way -> using Adjecency List
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }

        // adge 1-->2 ==> if undirected, if directed then only one side edge is required.
        adjList.get(1).add(2);
        adjList.get(2).add(1);

        // 2--> 3
        adjList.get(2).add(3);
        adjList.get(3).add(2);


        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j < adjList.get(i).size(); j++)
            {
                System.out.println(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
