public class Set_Matrix_Zeroes_73 {

    //TC -> O(N * M)
    //SC -> O(1)
    public void setZeroes(int[][] matrix) {
        // 0th row -> matrix[0][...]
        // 0th column -> matrix[..][j]

        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;

                    if (j != 0) matrix[0][j] = 0;
                    else col0 = 0;
                }
            }
        }
        for (int i = n-1; i >= 1; i--) {
            for (int j = m-1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = m-1; j>= 1; j--)  {
            if (matrix[0][0] == 0) {
                matrix[0][j] = 0;
            }
        }
        for (int i = n-1; i>= 0; i--) {
            if (col0 == 0) {
                matrix[i][0] = 0; 
            }
        }
    }


}