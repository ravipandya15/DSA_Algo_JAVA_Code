package PrefixSum;

public class Range_Sum_Query_2D_Immutable_304 {
    
}

class NumMatrix {

    int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        prefixSum = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++)
        {
            int prefix = 0;
            for (int j = 0; j < m; j++)
            {
                prefix += matrix[i][j];
                prefixSum[i + 1][j + 1] = prefix + prefixSum[i][j + 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1 = row1 + 1; 
        col1 = col1 + 1;
        row2 = row2 + 1;
        col2 = col2 + 1;

        int bottomRight = prefixSum[row2][col2];
        int above = prefixSum[row1 - 1][col2];
        int left = prefixSum[row2][col1 - 1];
        int topLeft = prefixSum[row1 - 1][col1 - 1];
        return bottomRight - above - left + topLeft;
    }
}