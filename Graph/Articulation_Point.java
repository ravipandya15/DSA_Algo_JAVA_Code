package Graph;

import java.util.ArrayList;;

class Main
{
    // doubt
    // timer starts with 0 and as per dry run it should start from 1
    // hear we are passing timer but it should be as reference -> not necessory but in C++ Code it's used as ref
    private static void dfs(int node, int parent, int[] visited, int[] tin, int[] low, int timer, 
                            ArrayList<ArrayList<Integer>> adj, int[] isArticulation)
    {
        visited[node] = 1;
        tin[node] = low[node] = timer++;

        int child = 0;

        for (Integer it : adj.get(node))
        {
            if (it == parent) continue;

            if (visited[it] == 0)
            {
                dfs(it, node, visited, tin, low, timer, adj, isArticulation);
                low[node] = Math.min(low[node], low[it]);

                child++;

                if (low[it] >= tin[node] && parent != -1)
                {
                    isArticulation[node] = 1;
                }
            }
            else
            {
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        if (child > 1 && parent == -1)
        {
            isArticulation[node] = 1;
        }
    }
    void findArticulationPoint(int N, ArrayList<ArrayList<Integer>> adj)
    {
        int[] visited = new int[N];
        int[] tin = new int[N];
        int[] low = new int[N];

        int[] isArticulation = new int[N];

        int timer = 0;
        for (int i = 0; i < N; i++)
        {
            if (visited[i] == 0)
            {
                dfs(i, -1, visited, tin, low, timer, adj, isArticulation);
            }
        }

        for(int i = 0; i < N; i++) {
            if(isArticulation[i] == 1) System.out.println(i); 
        }
    }
}

public class Articulation_Point {
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
        obj.findArticulationPoint(N, adj);
    }
}
