package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite_Graph {
    public static void main(String[] args) {
        
    }

    // BFS
    // TC > O(N+E)
    // SC -> O(N+E) + O(N) + O(N)
    public static boolean checkBFS(int node, int[] color, ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 0;

        while (!q.isEmpty())
        {
            Integer cur = q.peek();
            q.poll();
            for (Integer it : adj.get(cur))
            {
                if (color[it] == -1)
                {
                    q.add(it);
                    color[it] = 1 - color[cur];
                }
                else if (color[it] == color[cur])
                {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkBipartite1(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // this time it's 0 based indexing
        int[] color = new int[V];
        for (int i = 0; i < V; i++)
        {
            color[i] = -1;
        }

        // check for every component
        for (int i = 0; i < V; i++)
        {
            if (color[i] == -1)
            {
                if (checkBFS(i, color, adj) == false)
                {
                    return false;
                }
            }
        }

        return true;
    }

    // DFS
    // TC > O(N+E)
    // SC -> O(N+E) + O(N) + O(N)
    public static boolean checkDFS(int node, int[] color, ArrayList<ArrayList<Integer>> adj)
    {
        if (color[node] == -1)
            color[node] = 1;

        for (Integer it : adj.get(node))
        {
            if (color[it] == -1)
            {
                color[it] = 1 - color[node];
                if (!checkDFS(it, color, adj)) return false;
            }
            else if (color[it] == color[node]) return false;
        }
        return true;
    }
    

    public boolean checkBipartite(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // this time it's 0 based indexing
        int[] color = new int[V];
        for (int i = 0; i < V; i++)
        {
            color[i] = -1;
        }

        // check for every component
        for (int i = 0; i < V; i++)
        {
            if (color[i] == -1)
            {
                if (checkDFS(i, color, adj) == false)
                {
                    return false;
                }
            }
        }

        return true;
    }
}
