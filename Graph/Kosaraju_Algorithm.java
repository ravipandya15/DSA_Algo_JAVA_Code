package Graph;

import java.util.ArrayList;
import java.util.Stack;

class Main
{

    private static void dfs(int node, int[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj)
    {
        visited[node] = 1;

        for (Integer it : adj.get(node))
        {
            if (visited[it] == 0)
            {
                dfs(it, visited, st, adj);
            }
        }

        st.push(node);
    }

    private static void revDfs(int node, int[] visited, ArrayList<ArrayList<Integer>> transpose)
    {
        System.out.print(node + " ");
        visited[node] = 1;

        for (Integer it : transpose.get(node))
        {
            if (visited[it] == 0)
            {
                revDfs(it, visited, transpose);
            }
        }

    }

    public void kosaRaju(int N, ArrayList<ArrayList<Integer>> adj)
    {
        int[] visited = new int[N];
        Stack<Integer> st = new Stack<Integer>();

        // step 1
        // topological sort
        for (int i = 0; i < N; i++)
        {
            if (visited[i] == 0)
            {
                dfs(i, visited, st, adj);
            }
        }

        // step 2
        // transpose Graph
        // i->j to j->i

        ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < N; i++)
        {
            transpose.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < N; i++)
        {
            visited[i] = 0;
            for (Integer it : adj.get(i))
            {
                transpose.get(it).add(i);
            }
        }

        // step 3
        // dfs on Transpose

        while (!st.isEmpty())
        {
            Integer node = st.peek();
            st.pop();

            if (visited[node] == 0)
            {
                System.out.println("SSC : ");
                revDfs(node, visited, transpose);
                System.out.println();
            }
        }

    }
}

public class Kosaraju_Algorithm {
    public static void main(String[] args) {
        System.out.println("Kosaraju_Algorithm");
        int n = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
			
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(0);
		adj.get(1).add(3);
		adj.get(3).add(4);

			
		Main obj = new Main(); 
		obj.kosaRaju(n, adj); 
    }
}
