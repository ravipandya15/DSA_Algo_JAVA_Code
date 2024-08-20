package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair implements Comparator<Pair>
{
    private int v;
    private int weight;
    public Pair(int _v, int _w)
    {
        v = _v;
        weight = _w;
    }
    public Pair() {}
    public int getV() {
        return v;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public int compare(Pair pair1, Pair pair2) {
        if (pair1.weight < pair2.weight)
            return -1;
        if (pair1.weight > pair2.weight)
            return 1;
        return 0;
    }
}

public class Dijkstra_Shortest_Path_In_Directed_Graph {
    public static void main(String[] args) {
        
    }

    public void shortestPath_Dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int S)
    {
        // cosidering 0 based indexing
        int dist[] = new int[V];
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        // dist[S] = 0; as dist[S] should be 0 as we are starting from this node. double check this.
        // didn't understand
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(V, new Pair());
        pq.add(new Pair(S, 0));

        while (!pq.isEmpty())
        {
            Pair p = pq.peek();
            pq.poll();

            for (Pair it : adj.get(p.getV()))
            {
                if (dist[p.getV()] + it.getWeight() < dist[it.getV()])
                {
                    dist[it.getV()] = dist[p.getV()] + it.getWeight();
                    pq.add(new Pair(it.getV(), dist[it.getV()]));
                }
            }
        }
    }
}
