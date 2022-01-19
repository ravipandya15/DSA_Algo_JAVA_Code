package Graph;

import java.util.ArrayList;
import java.util.Stack;

class Pair
{
    private int v;
    private int weight;
    public Pair(int _v, int _w)
    {
        v = _v;
        weight = _w;
    }
    public int getV() {
        return v;
    }
    public int getWeight() {
        return weight;
    }
}
public class Shortest_Path_In_Directed_Acylic_Graph {
    public static void main(String[] args) {
        
    }

    private static void findTopologicalSort(int node, int[] visited, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj)
    {
        visited[node] = 1;

        for (Pair it : adj.get(node))
        {
            if (visited[it.getV()] == 0)
                findTopologicalSort(it.getV(), visited, st, adj);
        }

        st.push(node);
    }

    public int[] shortestPathInDAG(int V, int src, ArrayList<ArrayList<Pair>> adj)
    {
        Stack<Integer> st = new Stack<Integer>();
        int[] visited = new int[V];
        for (int i = 0; i < V; i++)
        {
            visited[i] = 0;
        }

        for (int i = 0; i < V; i++)
        {
            if (visited[i] == 0)
            {
                findTopologicalSort(i, visited, st, adj);
            }
        }

        int[] dist = new int[V];
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;
        while (!st.isEmpty())
        {
            int node = st.peek();
            st.pop();

            if (dist[node] != Integer.MAX_VALUE)
            {
                for (Pair it : adj.get(node))
                {
                    if (dist[node] + it.getWeight() < dist[it.getV()])
                    {
                        dist[it.getV()] = dist[node] + it.getWeight();
                    }
                }
            }
        }

        return dist;
    }
}
