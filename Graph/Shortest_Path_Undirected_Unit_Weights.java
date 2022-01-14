package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_Undirected_Unit_Weights {
    public static void main(String[] args) {
        
    }

    public void ShortestPath(int N, int src, ArrayList<ArrayList<Integer>> adj)
    {
        int dist[] = new int[N];
        for (int i = 0; i < N; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        dist[src] = 0;
        q.add(src);
        
        while (!q.isEmpty())
        {
            int node = q.peek();
            q.poll();

            for (Integer it : adj.get(node))
            {
                if (dist[node] + 1 < dist[it])
                {
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }

        for (int i = 0; i < N; i++)
        {
            System.out.println(dist[i] + " ");
        }
    }
}
