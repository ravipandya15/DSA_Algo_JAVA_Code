package Stack_and_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges_994 {
    public static void main(String[] args)
    {
        System.out.println("Implement_Stack_using_Queues_225");
    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int time = 0, totalOranges = 0, rottenOranges = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] != 0) totalOranges++;
                if (grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        if (totalOranges == 0) return 0;

        int dx[] = {0, 0, 1,-1};
        int dy[] = {1, -1, 0,0};

        while (!q.isEmpty())
        {
            int k = q.size();
            rottenOranges +=k;
            while(k > 0)
            {
                int[] point = q.peek();
                q.poll();
                for (int i = 0; i < 4; i++)
                {
                    int x = point[0], y = point[1];
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 1) continue;
                    grid[nx][ny] = 2;
                    q.add(new int[] {nx, ny});
                }
                k--;
            }
            if (!q.isEmpty()) time++;
        }

        return (totalOranges == rottenOranges) ? time : -1;
    }
}

