package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Word_Search_II_212 {
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

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        int N = words.length;
        boolean flag = false;

        for (int k = 0; k < N; k++)
        {
            String word = words[k];
            flag = false;
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (board[i][j] == word.charAt(0))
                    {
                        if (solve(i, j, board, word, m, n, visited, 0, word.length()))
                        {
                            ans.add(word);
                            visited = new int[m][n];
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag) break;
            }
        }
        return ans;
    }
}
