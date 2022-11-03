package Graph.Problems;

public class Number_of_Enclaves_1020 {

    public static int dfs(int i, int j, int[][] grid, int[][] visited, int n, int m)
    {
        // base case
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0 || visited[i][j] == 1) return 0;
        visited[i][j] = 1;
        int count = 1;

        count += dfs(i + 1, j, grid, visited, n, m);
        count += dfs(i - 1, j, grid, visited, n, m);
        count += dfs(i, j + 1, grid, visited, n, m);
        count += dfs(i, j - 1, grid, visited, n, m);
        return count;
    }
    public int numEnclaves(int[][] grid) {
        int totalOnes = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (grid[i][j] == 1) totalOnes++;
            }
        }

        int[][] visited = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            if (grid[i][0] == 1 && visited[i][0] == 0)
            {
                count += dfs(i, 0, grid, visited, n, m);
            }
            if (grid[i][m-1] == 1 && visited[i][m-1] == 0)
            {
                count += dfs(i, m-1, grid, visited, n, m);
            }
        }

        for (int j = 0; j < m; j++)
        {
            if (grid[0][j] == 1 && visited[0][j] == 0)
            {
                count += dfs(0, j, grid, visited, n, m);
            }
            if (grid[n-1][j] == 1 && visited[n-1][j] == 0)
            {
                count += dfs(n-1, j, grid, visited, n, m);
            }
        }
        return totalOnes - count;
    }
}
