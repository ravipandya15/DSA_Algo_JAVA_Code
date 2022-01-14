package Graph;

import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {
        
    }

    private static void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs)
    {
        dfs.add(node);
        visited[node] = true;

        for (Integer it : adj.get(node))
        {
            if (!visited[it])
            {
                dfs(it, visited, adj, dfs);
            }
        }
    }

    public static ArrayList<Integer> DFSTravsersal(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean visited[] = new boolean[V+1];

        for (int i = 1; i <= V; i++)
        {
            if (!visited[i])
                dfs(i, visited, adj, dfs);
        }

        return dfs;
    }
}
