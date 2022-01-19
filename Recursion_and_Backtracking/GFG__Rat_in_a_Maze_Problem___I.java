package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.List;

class Solution
{
	public static void main(String Args[])
	{
		System.out.println("GFG) Rat in a Maze Problem - I ");
		int[][] m = new int[][]
        {
            {1,0,0,0 },
            {1,1,0,1 },
            {1,1,0,0 },
            {0,1,1,1 }
        };
        var result = findPath(m, 4);
	}
	
	// approach - 2
	public static ArrayList<String> findPath(int[][] m, int n) {
		ArrayList<String> ans = new ArrayList<String>();
		int[][] visited = new int[n][n];
        String move = "";
        int[] di = { 1, 0, 0, -1 };
        int[] dj = { 0, -1, 1, 0 };
        if (m[0][0] == 1) Solve(0, 0, m, visited, di, dj, move, n, ans);
        return ans;
    }
	
	// approach - 2
	public static void Solve(int i, int j, int[][] m, int[][] visited, int[] di, int[] dj, String move, int n, ArrayList<String> ans)
	{
		// base condition
        if (i == n - 1 && j == n - 1)
        {
            ans.add(new String(move));
            //ans.add(move); this will also work
            return;
        }

        String dir = "DLRU";
        for (int ind = 0; ind < 4; ind++) // loop for 4 direction
        {
            int nexti = i + di[ind];
            int nextj = j + dj[ind];
            if (nexti >= 0 && nexti < n && nextj >= 0 && nextj < n // check for all boundry cases
                && m[nexti][nextj] == 1 && visited[nexti][nextj] != 1)
            {
                visited[i][j] = 1;
                Solve(nexti, nextj, m, visited, di, dj, move + dir.charAt(ind), n, ans);
                visited[i][j] = 0;
            }
        }
	}
	
	
	// approach -1 
	public static ArrayList<String> findPath1(int[][] m, int n) {
		ArrayList<String> ans = new ArrayList<String>();
        int[][] visited = new int[n][n];
        String move = "";
        if (m[0][0] == 1) Solve1(0, 0, m, visited, move, n, ans);
        return ans;
    }
	
	// approach - 2
	public static void Solve1(int i, int j, int[][] m, int[][] visited, String move, int n, ArrayList<String> ans)
    {
        // base condition
        if (i == n-1 && j == n-1)
        {
            ans.add(new String(move));
            return;
        }

        // lexicographical order -> DLRU
        // down
        if (i + 1 < n && m[i + 1][j] == 1 && visited[i + 1][j] != 1)
        {
            visited[i][j] = 1;
            Solve1(i + 1, j, m, visited, move + 'D', n, ans);
            visited[i][j] = 0;
        }

        // left
        if (j - 1 >= 0 && m[i][j - 1] == 1 && visited[i][j - 1] != 1)
        {
        	visited[i][j] = 1;
            Solve1(i, j - 1, m, visited, move + 'L', n, ans);
            visited[i][j] = 0;
        }

        // right
        if (j + 1 < n && m[i][j + 1] == 1 && visited[i][j + 1] != 1)
        {
        	visited[i][j] = 1;
            Solve1(i, j + 1, m, visited, move + 'R', n, ans);
            visited[i][j] = 0;
        }

        // up
        if (i - 1 >= 0 && m[i - 1][j] == 1 && visited[i - 1][j] != 1)
        {
        	visited[i][j] = 1;
            Solve1(i - 1, j, m, visited, move + 'U', n, ans);
            visited[i][j] = 0;
        }
    }
}