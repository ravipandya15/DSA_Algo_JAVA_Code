package Graph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;;

// for brute force
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

// for efficient one -> Heap DS
class Node implements Comparator<Node>
{
    private int v;
    private int weight;
    public Node(int _v, int _w)
    {
        v = _v;
        weight = _w;
    }
    public Node() {}
    public int getV() {
        return v;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public int compare(Node pair1, Node pair2) {
        if (pair1.weight < pair2.weight)
            return -1;
        if (pair1.weight > pair2.weight)
            return 1;
        return 0;
    }
}

public class Prim_Algo_MST {
    public static void main(String[] args) {
        
    }

    // TC -> O((N + E) + NLogN)
    // efficient
    public static void primAlgo_Efficient(int N, ArrayList<ArrayList<Pair>> adj)
    {
        int key[] = new int[N];
        boolean mst[] = new boolean[N];
        int parent[] = new int[N];

        // initialization
        for (int i = 0; i < N; i++)
        {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mst[i] = false;
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());

        key[0] = 0;
        parent[0] = -1; // as 0 does not have any parent
        pq.add(new Node(0, key[0]));
        // as MST Contains V-1 Edges
        while (!pq.isEmpty())
        {
            int u = pq.peek().getV();
            pq.poll();

            mst[u] = true;

            for (Pair it : adj.get(u))
            {
                if (mst[it.getV()] == false && it.getWeight() < key[it.getV()])
                {
                    key[it.getV()] = it.getWeight();
                    parent[it.getV()] = u;
                    pq.add(new Node(it.getV(), key[it.getV()]));
                }
            }

            for (int i = 1; i < N; i++)
            {
                System.out.println(parent[i] + "--->" + i);
            }
        }
    }
    // TC -> O(N) + O((N*N) + (N + E))
    // brute force
    public static void primAlgo_BruteForce(int N, ArrayList<ArrayList<Pair>> adj)
    {
        int key[] = new int[N];
        boolean mst[] = new boolean[N];
        int parent[] = new int[N];

        // initialization
        for (int i = 0; i < N; i++)
        {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mst[i] = false;
        }

        key[0] = 0;
        parent[0] = -1; // as 0 does not have any parent
        // as MST Contains V-1 Edges
        for (int i = 0; i < N-1; i++)
        {
            int u = 0;
            int mini = Integer.MAX_VALUE;
            // find min. value from Key array
            for (int v = 0; v < N; i++)
            {
                if (mst[v] == false && key[v] < mini)
                {
                    mini = key[v];
                    u = v;
                }
            }

            mst[u] = true;

            for (Pair it : adj.get(u))
            {
                if (mst[it.getV()] == false && it.getWeight() < key[it.getV()])
                {
                    key[it.getV()] = it.getWeight();
                    parent[it.getV()] = u;
                }
            }
        }

        for (int i = 1; i < N; i++)
        {
            System.out.println(parent[i] + "--->" + i);
        }
    }
}
