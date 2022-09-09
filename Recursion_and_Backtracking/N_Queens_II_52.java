package Recursion_and_Backtracking;

public class N_Queens_II_52 {
    // best solution
    public int totalNQueens(int n) {
        int[] ans = {0};
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
        solve(0, boards, ans, leftRow, lowerDiagonal, upperDiagonal);
        return ans[0];
    }

    public static void solve(int col, char[][] boards, int[] ans, int leftRow[], int lowerDiagonal[], int upperDiagonal[])
	{
		// base condition
        if (col == boards.length)
        {
            ans[0]++;
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
                solve(col + 1, boards, ans, leftRow, lowerDiagonal, upperDiagonal);
                boards[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[boards.length - 1 + col - row] = 0;
            }
        }
	}

    public int totalNQueens_1(int n) {
        int[] ans = {0};
        char[][] boards = new char[n][n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                boards[i][j] = '.';
            }
        }
        solve1(0, boards, ans, n);
        return ans[0];
    }

    public static void solve1(int col, char[][] boards, int[] ans, int n)
    {
        // base condition
        if (col == n)
        {
            ans[0]++;
            return;
        }

        for (int row = 0; row < n; row++)
        {
            if (IsSafe(row, col, boards, n))
            {
                boards[row][col] = 'Q';
                solve1(col+1, boards, ans, n);
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
