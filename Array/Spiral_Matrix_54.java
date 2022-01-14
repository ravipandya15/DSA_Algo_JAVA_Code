package Array;

import java.util.ArrayList;
import java.util.List;

public abstract class Spiral_Matrix_54 {
    public static void main(String[] args)
    {
        System.out.println("CN) Print Like a Wave");
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        int total = row * col;

        // initialize Index;
        int startingRow = 0, starttingCol = 0, endingRow = row - 1, enddingCol = col - 1;

        while (count < total)
        {
            // print starting row
            for (int index = starttingCol; count < total && index <= enddingCol; index++)
            {
                ans.add(matrix[startingRow][index]);
                count++;
            }
            startingRow++;

            // print ending Col
            for (int index = startingRow; count < total && index <= endingRow; index++)
            {
                ans.add(matrix[index][enddingCol]);
                count++;
            }
            enddingCol--;

            // print ending Row
            for (int index = enddingCol; count < total && index >= starttingCol; index--)
            {
                ans.add(matrix[endingRow][index]);
                count++;
            }
            endingRow--;

            // print starting Col
            for (int index = endingRow; count < total && index >= startingRow; index--)
            {
                ans.add(matrix[index][starttingCol]);
                count++;
            }
            starttingCol++;
        }
        return ans;
    }
}
