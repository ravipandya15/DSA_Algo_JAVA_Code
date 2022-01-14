package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
    }

    public static ArrayList<Integer> BFSTraversal(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> bfs = new ArrayList<Integer>();
        boolean[] visited = new boolean[V+1];

        // loop for every component
        for (int i = 1; i <= V; i++)
        {
            if (visited[i] == false)
            {
                
                // bfs
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;

                while (!q.isEmpty())
                {
                    Integer node = q.peek();
                    q.poll();
                    bfs.add(node);

                    for (Integer it : adj.get(node))
                    {
                        if (!visited[it])
                        {
                            q.add(it);
                            visited[it] = true;
                        }
                    }
                }

            }
        }

        return bfs;
    }
}
