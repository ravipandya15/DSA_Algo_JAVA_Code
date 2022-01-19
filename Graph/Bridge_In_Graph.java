package Graph;

import java.util.ArrayList;

class Main
{
    // doubt
    // timer starts with 0 and as per dry run it should start from 1
    // hear we are passing timer but it should be as reference -> not necessory but in C++ Code it's used as ref
    private static void dfs(int node, int parent, int[] visited, int[] tin, int[] low, int timer, ArrayList<ArrayList<Integer>> adj)
    {
        visited[node] = 1;
        tin[node] = low[node] = timer++;

        for (Integer it : adj.get(node))
        {
            if (it == parent) continue;

            if (visited[it] == 0)
            {
                dfs(it, node, visited, tin, low, timer, adj);
                low[node] = Math.min(low[node], low[it]);

                if (low[it] > tin[node])
                {
                    System.out.println(it + " --- " + node);
                }
            }
            else
            {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
    }
    void printBridges(int N, ArrayList<ArrayList<Integer>> adj)
    {
        int[] visited = new int[N];
        int[] tin = new int[N];
        int[] low = new int[N];

        int timer = 0;
        for (int i = 0; i < N; i++)
        {
            if (visited[i] == 0)
            {
                dfs(i, -1, visited, tin, low, timer, adj);
            }
        }
    }
}
public class Bridge_In_Graph {
    public static void main(String[] args) {
        int N = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < N; i++) 
			adj.add(new ArrayList<Integer>());

        adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(0).add(2);
		adj.get(2).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(1).add(3);
		adj.get(3).add(1);

		adj.get(3).add(4);
		adj.get(4).add(3);
        Main obj = new Main();
        obj.printBridges(N, adj);
    }
}
