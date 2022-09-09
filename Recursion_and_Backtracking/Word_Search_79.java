package Recursion_and_Backtracking;

public class Word_Search_79 {
    public boolean solve(int i, int j, char[][] board, String word, int m, int n, int[][] visited, int index, int N)
    {
        // base case
        if (index == N) return true;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (visited[i][j] == 1) return false;

        if (board[i][j] != word.charAt(index)) return false;
        visited[i][j] = 1;
        if (solve(i-1, j, board, word, m, n, visited, index + 1, N)
         || solve(i+1, j, board, word, m, n, visited, index + 1, N)
         || solve(i, j-1, board, word, m, n, visited, index + 1, N)
         || solve(i, j+1, board, word, m, n, visited, index + 1, N))
        {
            return true;
        }
        visited[i][j] = 0;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean ans = false;
        int[][] visited = new int[m][n];
        int N = word.length();

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == word.charAt(0))
                {
                    ans = solve(i, j, board, word, m, n, visited, 0, N);
                    if (ans) return true;
                }
            }
        }
        return ans;
    }
}
