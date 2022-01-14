package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node
{
    int first;
    int second;
    public Node(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}

public class Cycle_Detection_Undirected_Graph {
    public static void main(String[] args) {
        
    }

    // BFS
    // TC -> O(N+E)
    // SC -> O(N+E) + O(N) + O(N)
    private static boolean checkForCycle_BFS(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Node> q = new LinkedList<>(); // BFS
        q.add(new Node(i, -1));
        visited[i] = true;

        while(!q.isEmpty())
        {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.poll();

            for (Integer it : adj.get(node))
            {
                if (!visited[it])
                {
                    q.add(new Node(it, node));
                    visited[it] = true;
                }
                else
                {// means it is visited so check is it is parent or not
                    if (it != parent) return true;
                }
            }
        }


        return false;
    }

    public static boolean isCycle_BFS(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V+1];
        for (int i = 1; i <= V; i++)
        {
            if (!visited[i])
            {
                if (checkForCycle_BFS(i, visited, adj)) return true;
            }
        }

        return false;
    }


    // DFS
    // TC -> O(N+E)
    // SC -> O(N+E) + O(N) + O(N)
    private static boolean checkForCycle_DFS(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj)
    {
        visited[node] = true;

        for (Integer it : adj.get(node))
        {
            if (!visited[it])
            {
                if (checkForCycle_DFS(it, node, visited, adj)) return true;
            }
            else{
                if (it != parent) return true;
            }
        }
        return false;
    }


    public static boolean isCycle_DFS(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V+1];
        for (int i = 1; i <= V; i++)
        {
            if (!visited[i])
            {
                if (checkForCycle_DFS(i, -1, visited, adj)) return true;
            }
        }

        return false;
    }
}


