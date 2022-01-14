package Recursion;

import java.util.ArrayList;

public class Rat_in_a_Maze_Problem_I {
    
    // Approach 2
    public static ArrayList<String> findPath1(int[][] m, int n) {
        
        ArrayList<String> result = new ArrayList<String>();
        if (m[0][0] == 0)
            return result;

        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                visited[i][j] = 0;
            }
        }
        int x = 0, y = 0;
        String ans = "";

        // DLRU
        // X - axis is !
        //             !
        //             !
        //             !

        // Y - axis is ------>

        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        solve1(m, n, x, y, dx, dy, ans, result, visited);
        return result;
    }

    private static void solve1(int[][] m, int n, int x, int y, int[] dx, int[] dy, String ans, ArrayList<String> result, int[][] visited)
    {
        // base case
        if (x == n-1 && y == n-1)
        {
            result.add(new String(ans));
            return;
        }

        // lexicographical order > DLRU

        String dir = "DLRU";
        for (int i = 0; i < 4; i++)
        {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (isSafe(newX, newY, m, n, visited))
            {
                visited[x][y] = 1;
                solve1(m, n, newX, newY, dx, dy, ans + dir.charAt(i), result, visited);
                visited[x][y] = 0;
            }
        }
    }

    // Approach - 1
    private static boolean isSafe(int newX, int newY, int[][] m, int n, int[][] visited)
    {
        if (newX >= 0 && newX < n && newY >= 0 && newY < n && m[newX][newY] == 1 && visited[newX][newY] == 0)
        {
            return true;
        }
        return false;
    }

    private static void solve(int[][] m, int n, int x, int y, String ans, ArrayList<String> result, int[][] visited)
    {
        // base case
        if (x == n-1 && y == n-1)
        {
            result.add(new String(ans));
            return;
        }

        // now you are at x,y
        visited[x][y] = 1;

        // lexicographical order > DLRU

        // down
        int newX = x + 1;
        int newY = y;
        if (isSafe(newX, newY, m, n, visited))
        {
            solve(m, n, newX, newY, ans + "D", result, visited);
        }

        // left
        newX = x;
        newY = y - 1;
        if (isSafe(newX, newY, m, n, visited))
        {
            solve(m, n, newX, newY, ans + "L", result, visited);
        }

        // right
        newX = x;
        newY = y + 1;
        if (isSafe(newX, newY, m, n, visited))
        {
            solve(m, n, newX, newY, ans + "R", result, visited);
        }

        // Up
        newX = x - 1;
        newY = y;
        if (isSafe(newX, newY, m, n, visited))
        {
            solve(m, n, newX, newY, ans + "U", result, visited);
        }

        // back-tracking
        visited[x][y] = 0;
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (m[0][0] == 0)
            return result;

        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                visited[i][j] = 0;
            }
        }
        int x = 0, y = 0;
        String ans = "";
        solve(m, n, x, y, ans, result, visited);
        return result;
    }
    
}
