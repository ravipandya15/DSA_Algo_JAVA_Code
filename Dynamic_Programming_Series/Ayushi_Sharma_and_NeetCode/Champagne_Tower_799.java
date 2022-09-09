package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

public class Champagne_Tower_799 {
    double champagneTower(int poured, int query_row, int query_glass) {
        double[][] matrix = new double[101][101];
        matrix[0][0] = poured;

        for (int i = 0; i <= query_row; i++)
        {
            for (int j = 0; j <= query_glass; j++)
            {
                if (matrix[i][j] > 1)
                {
                    double splitted = (matrix[i][j] - 1.0) / 2.0;
                    matrix[i+1][j] += splitted;
                    matrix[i+1][j+1] += splitted;
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix[query_row][query_glass];
    }
}
