package Graph;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

class Node 
{
    private int v;
    private int u;
    private int weight;
    public Node(int _v, int _u, int _w)
    {
        v = _v;
        u = _u;
        weight = _w;
    }

    public Node() {}

    public int getU() { return u; }
    public int getV() { return v; }
    public int getWeight() { return weight; }
}

class SortComparator implements Comparator<Node>
{
    @Override
    public int compare(Node n1, Node n2)
    {
        if (n1.getWeight() < n2.getWeight()) return -1;
        else if (n2.getWeight() < n1.getWeight()) return 1;
        return 0;
    }
}

class Main
{
    public static void makeSet(int size, int[] parent, int[] rank)
    {
        for (int i = 0; i < size; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // compression 7 -> 6 -> 5 -> 4 -> 3
    public static int findParent(int node, int[] parent)
    {
        if (node == parent[node])
        {
            return node;
        }

        // storing in parent[node] is path compression 
        return parent[node] = findParent(parent[node], parent);

        // or we can write like this
        //parent[node] = findParent(parent[node], parent);
        //return parent[node];
    }

    public static void Union(int u, int v, int[] parent, int[] rank)
    {
        int i = findParent(u, parent);
        int j = findParent(v, parent);

        // if both i and i are in same set
        if (i == j) return;

        if (rank[i] < rank[j])
        {
            parent[i] = j;
        }
        else if (rank[j] < rank[i])
        {
            parent[j] = i;
        }
        else
        {// means rank of i and j are same
            parent[j] = i;
            rank[i]++;
        }
    }

    public void kruskal_Algo(int N, ArrayList<Node> adj)
    {
        Collections.sort(adj, new SortComparator());
        int parent[] = new int[N];
        int rank[] = new int[N];

        makeSet(N, parent, rank);

        int cost = 0;
        ArrayList<Node> mst = new ArrayList<Node>();

        for (Node it : adj)
        {
            if (findParent(it.getU(), parent) != findParent(it.getV(), parent))
            {
                cost += it.getWeight();
                mst.add(it);
                Union(it.getU(), it.getV(), parent, rank);
            }
        }

        System.out.println("Cost of spanning tree is " + cost);
        for (Node it : mst)
        {
            System.out.println(it.getU() + "--->" + it.getV());
        }
    }
}


public class Kruskal_Algorithm {
    public static void main(String[] args) {
        System.out.println("Kriskal's Algorithm");
        int n = 5; // size of nodes

        ArrayList<Node> adj = new ArrayList<Node>();
        adj.add(new Node(0, 1, 2));
        adj.add(new Node(0, 3, 6));
		adj.add(new Node(1, 3, 8));
		adj.add(new Node(1, 2, 3));
		adj.add(new Node(1, 4, 5));
		adj.add(new Node(2, 4, 7));

        Main obj = new Main();
        obj.kruskal_Algo(n, adj);
    }
}
