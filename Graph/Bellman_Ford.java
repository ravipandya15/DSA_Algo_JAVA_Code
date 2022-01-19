package Graph;

import java.util.ArrayList;

class Node
{
    int u;
    int v;
    int weight;
    Node(int _u, int _v, int _w)
    {
        u = _u;
        v = _v;
        weight = _w;
    }

    Node() {}

    public int getU() {
        return u;
    }
    public int getV() {
        return v;
    }
    public int getWeight() {
        return weight;
    }
}

class Main
{
    public void bellmanFord(ArrayList<Node> adj, int n, int src)
    {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;

        for (int i = 1; i <= n-1; i++)
        {
            for (Node it : adj)
            {
                if (dist[it.getU()] + it.getWeight() < dist[it.getV()])
                {
                    dist[it.getV()] = dist[it.getU()] + it.getWeight();
                }
            }
        }

        int flag = 0;

        for (Node it : adj)
        {
            if (dist[it.getU()] + it.getWeight() < dist[it.getV()])
            {
               flag = 1;
               System.out.println("Negative Cycle");
               break;
            }
        }

        if (flag == 0)
        {
            for (int i = 0; i < n; i++)
            {
                System.out.println( "Shortest distance from " + src + " to " + i + " is " + dist[i]);
            }
        }
    }
}

public class Bellman_Ford {
    public static void main(String[] args) {
        int n = 6;
        ArrayList<Node> adj = new ArrayList<Node>();
		
			
		adj.add(new Node(3, 2, 6));
		adj.add(new Node(5, 3, 1));
		adj.add(new Node(0, 1, 5));
		adj.add(new Node(1, 5, -3));
		adj.add(new Node(1, 2, -2));
		adj.add(new Node(3, 4, -2));
		adj.add(new Node(2, 4, 3));

	
		Main obj = new Main(); 
		obj.bellmanFord(adj, n, 0);
    }
}
