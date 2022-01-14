package Array;

public class Search_a_2D_Matrix_II_240 {
    public static void main(String[] args)
    {
        System.out.println("CN) Print Like a Wave");
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int rowIndex = 0;
        int colIndex = col - 1;

        while (rowIndex < row && colIndex >= 0)
        {
            if (matrix[rowIndex][colIndex] == target)
                return true;

            if (matrix[rowIndex][colIndex] < target)
                rowIndex++;

            else
                colIndex--;
        }
        return false;
    }
}
