package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Topological_Sort {
    public static void main(String[] args) {
        System.out.println("Topological Sorting usinf DFS and BFS(Kahn's Algorithm)");
    }

    // DFS
    // TC -> O(N + E)
    // SC -> O(N+E) + O(N) + O(N) + O(N)
    private static void findTopoSort(int node, Stack<Integer> st, int[] visited, ArrayList<ArrayList<Integer>> adj)
    {
        visited[node] = 1;

        for (Integer it : adj.get(node))
        {
            if (visited[it] == 0)
            {
                findTopoSort(it, st, visited, adj);
            }
        }

        st.push(node);
    }

    public static int[] topoSort1(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st = new Stack<Integer>();
        int[] visited = new int[V]; // considering 0 based indexing

        for (int i = 0; i < V; i++)
        {
            if (visited[i] == 0)
            {
                findTopoSort(i, st, visited, adj);
            }
        }

        int[] ans = new int[V];
        int index = 0;
        while (!st.isEmpty())
        {
            ans[index++] = st.peek();
            st.pop();
        }

        return ans;
    }

    // Kahn's Algorithm
    // BFS
    // TC -> O(N + E)
    // SC -> O(N+E) + O(N) + O(N) + O(N) 
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++)
        {
            for (Integer it : adj.get(i))
            {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++)
        {
            if (indegree[i] == 0)
            {
                q.add(i);
            }
        }

        int[] ans = new int[V];
        int index = 0;
        while (!q.isEmpty())
        {
            Integer node = q.peek();
            ans[index++] = node;
            q.poll();
            
            for (Integer it : adj.get(node))
            {
                indegree[it]--;
                if (indegree[it] == 0)
                {
                    q.add(it);
                }
            }
        }

        return ans;

    }
}
