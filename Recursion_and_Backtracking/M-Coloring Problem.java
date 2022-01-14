import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution
{
	public static void main(String Args[])
	{
		System.out.println("M - Coloring problem");
		int m = 3;
        int v = 4;
        List<Integer> graph[] = new ArrayList[v];
        graph[0] = new ArrayList<Integer>();
        graph[0].add(1);
        graph[0].add(2);
        graph[0].add(3);
        
        graph[1] = new ArrayList<Integer>();
        graph[1].add(2);
        graph[1].add(3);
        
        graph[2] = new ArrayList<Integer>();
        graph[2].add(0);
        graph[2].add(1);
        
        graph[3] = new ArrayList<Integer>();
        graph[3].add(0);
        graph[3].add(1);
        
        int[] color = {0};
        System.out.println("Is possible to with {m} colors ? - " + graphColoring(graph, color, m, v));
	}
	
	public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) 
    {
		int n = G.length;
		if (Solve(0, color, G, C, n))  // C is colors
            return true;
        return false;
    }
	
	public static boolean Solve(int node, int[] color, List<Integer>[] graph, int m, int n)
    {
        if (node == n)
            return true;

        for (int i = 1; i <= m; i++) // try all colors
        {
            if (IsPossible(node, color, graph, n, i))
            {
                color[node] = i;
                if (Solve(node + 1, color, graph, m, n))
                    return true;
                color[node] = 0; // backtracking step
            }
        }
        return false; // as I check all color but not possible for any color.
    }
	
	public static boolean IsPossible(int node, int[] color, List<Integer>[] graph, int n, int col)
    {
        for (int it : graph[node]) // check for all nodes
        {
            if (color[it] == col)
                return false;
        }
        return true;
    }
}