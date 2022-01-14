package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cycle_Detection_Directed_Graph {
    public static void main(String[] args) {
        
    }

    // Kahn's Algorithm (BFS)
    // TC -> O(N+E)
    // SC -> O(N+E) + O(N) + O(N)
    public static boolean isCycle_BFS(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++)
        {
            for (Integer it : adj.get(i))
            {
                inDegree[it]++;
            }
        }

        for (int i = 0; i < V; i++)
        {
            if (inDegree[i] == 0)
            {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty())
        {
            Integer node = q.peek();
            q.poll();
            count++;

            for (Integer it : adj.get(node))
            {
                inDegree[it]--;
                if (inDegree[it] == 0)
                {
                    q.add(it);
                }
            }
        }

        if (count == V) return false; // as topological sort is possible, so there will not be any clcle in graph
        return true;
    }



    // DFS
    // TC -> O(N+E)
    // SC -> O(N+E) + O(N) + O(N)
    private static boolean checkForCycle_DFS(int node, int[] vis, int[] dfsVis, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = 1;
        dfsVis[node] = 1;

        for (Integer it : adj.get(node))
        {
            if (vis[it] == 0)
            {
                if (checkForCycle_DFS(it, vis, dfsVis, adj)) return true;
            }
            else if (dfsVis[it] == 1) return true;
        }

        dfsVis[node] = 0;
        return false;
    }

    public static boolean isCycle_DFS(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // 0 based indexing
        int[] vis = new int[V];
        int[] dfsVis = new int[V];

        for (int i = 0; i < V; i++)
        {
            if (vis[i] == 0)
            {
                if (checkForCycle_DFS(i, vis, dfsVis, adj)) return true;
            }
        }
        return false;
    }
}
