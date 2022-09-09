package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution
{
	public static void main(String Args[])
	{
		System.out.println("N-Queen Problem");
		int n = 4;
        List<List<String>> result = SolveNQueens(n);
	}
	
	public static List<List<String>> SolveNQueens(int n)
    {
        List<List<String>> ans = new ArrayList<List<String>>();
        char[][] boards = new char[n][n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                boards[i][j] = '.';
            }
        }
        int leftRow[] = new int[n];
        int lowerDiagonal[] = new int[2 * n - 1];
        int upperDiagonal[] = new int[2 * n - 1];
        Solve(0, boards, ans, leftRow, lowerDiagonal, upperDiagonal);
        return ans;
    }
	
	public static void Solve(int col, char[][] boards, List<List<String>> ans, int leftRow[], int lowerDiagonal[], int upperDiagonal[])
	{
		// base condition
        if (col == boards.length)
        {
            ans.add(Construct(boards));
            return;
        }

        for (int row = 0; row < boards.length; row++)
        {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0
                && upperDiagonal[boards.length - 1 + col - row] == 0)
            {
                boards[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[boards.length - 1 + col - row] = 1;
                Solve(col + 1, boards, ans, leftRow, lowerDiagonal, upperDiagonal);
                boards[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[boards.length - 1 + col - row] = 0;
            }
        }
	}
	
	private static List<String> Construct(char[][] boards)
    {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < boards.length; i++)
        {
            String s = new String(boards[i]);
            res.add(s);
        }
        return res;
    }
	
	public static List<List<String>> SolveNQueens1(int n)
    {
        List<List<String>> ans = new ArrayList<List<String>>();
        char[][] boards = new char[n][n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                boards[i][j] = '.';
            }
        }
        Solve1(0, boards, ans, n);
        return ans;
    }
	
	public static void Solve1(int col, char[][] boards, List<List<String>> ans, int n)
    {
        // base condition
        if (col == n)
        {
            ans.add(Construct(boards));
            return;
        }

        for (int row = 0; row < n; row++)
        {
            if (IsSafe(row, col, boards, n))
            {
                boards[row][col] = 'Q';
                Solve1(col+1, boards, ans, n);
                boards[row][col] = '.';
            }
        }
    }
	
	private static boolean IsSafe(int row, int col, char[][] boards, int n)
    {
        int tempRow = row;
        int tempCol = col;

        // check left direction
        while (tempCol >= 0)
        {
            if (boards[tempRow][tempCol] == 'Q') return false;
            tempCol--;
        }

        tempRow = row;
        tempCol = col;
        // check uppper diagonal
        while (tempCol >= 0 && tempRow >= 0)
        {
            if (boards[tempRow][tempCol] == 'Q') return false;
            tempCol--;
            tempRow--;
        }

        tempRow = row;
        tempCol = col;

        // check lower diagonal
        while (tempCol >= 0 && tempRow < n)
        {
            if (boards[tempRow][tempCol] == 'Q') return false;
            tempCol--;
            tempRow++;
        }

        return true;
    }
}