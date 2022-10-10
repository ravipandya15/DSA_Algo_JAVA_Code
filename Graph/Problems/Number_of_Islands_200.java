package Graph.Problems;

public class Number_of_Islands_200 {

    public static void dfs(int i, int j, char[][] grid, int[][] visited, int n, int m)
    {
        visited[i][j] = 1;

        int[] di = new int[]{0, 0, 1, -1};
        int[] dj = new int[]{1, -1, 0, 0};

        for (int k = 0; k < 4; k++)
        {
            int row = i + di[k], col = j + dj[k];
            if (row >= 0 && row < n && col >= 0 && col < m &&
                grid[row][col] == '1' && visited[row][col] != 1)
                {
                    dfs(row, col, grid, visited, n, m);
                }
        }
    }
    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int island = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (grid[i][j] == '1' && visited[i][j] != 1)
                {
                    island++;
                    dfs(i, j, grid, visited, n, m);
                }
            }
        }
        return island;
    }
}
