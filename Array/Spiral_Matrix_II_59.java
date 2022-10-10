package Array;

public class Spiral_Matrix_II_59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startingRow = 0, endingRow = n-1, startingCol = 0, endingCol = n-1;
        int count = 1;

        while (count <= n * n)
        {
            for (int i = startingCol; count <= n * n && i <= endingCol; i++)
            {
                matrix[startingRow][i] = count++;
            }
            startingRow++;

            for (int i = startingRow; count <= n * n && i <= endingRow; i++)
            {
                matrix[i][endingCol] = count++;
            }
            endingCol--;

            for (int i = endingCol; count <= n * n && i >= startingCol; i--)
            {
                matrix[endingRow][i] = count++;
            }
            endingRow--;

            for (int i = endingRow; count <= n * n && i >= startingRow; i--)
            {
                matrix[i][startingCol] = count++;
            }
            startingCol++;
        }
        return matrix;
    }
}
