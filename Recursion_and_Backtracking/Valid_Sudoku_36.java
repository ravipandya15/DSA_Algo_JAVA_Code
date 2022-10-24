package Recursion_and_Backtracking;

public class Valid_Sudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        return solve(board);
    }

    public static boolean solve(char[][] board)
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] != '.')
                {
                    if (!isValid(board, i, j))
                    {
                        System.out.println("i : " + i + "j : " + j);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col)
    {
        for (int i = 0; i < 9; i++)
        {
            if (i != col && board[row][i] != '.' && board[row][i] == board[row][col]) return false;
            if (i != row && board[i][col] != '.' && board[i][col] == board[row][col]) return false;
            if ((3 * (row / 3) + i / 3 != row) && 3 * ((row / 3) + i / 3) != col && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' 
                && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == board[row][col]) return false;
        }
        return true;
    }
}
