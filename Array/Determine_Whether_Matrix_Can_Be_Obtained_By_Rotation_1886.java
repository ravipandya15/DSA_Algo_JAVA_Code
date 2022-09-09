package Array;

public class Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation_1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int i = 0, j = n - 1;

        int flag = 0;
        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (mat[i][j] != target[j][n-i-1])
                {
                    flag = -1;
                    break;
                }
            }
            if (flag == -1) break;
        }

        if (flag == 0 && i == n && j == n) return true;
        i = 0;
        j = n-1;
        flag = 0;

        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (mat[i][j] != target[n-i-1][n-j-1])
                {
                    flag = -1;
                    break;
                }
            }
            if (flag == -1) break;
        }

        if (flag == 0 && i == n && j == n) return true;
        i = 0;
        j = n-1;
        flag = 0;

        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (mat[i][j] != target[n-j-1][i])
                {
                    flag = -1;
                    break;
                }
            }
            if (flag == -1) break;
        }

        if (flag == 0 && i == n && j == n) return true;
        i = 0;
        j = n-1;
        flag = 0;

        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (mat[i][j] != target[i][j])
                {
                    flag = -1;
                    break;
                }
            }
            if (flag == -1) break;
        }

        if (flag == 0 && i == n && j == n) return true;
        return false;
    }
}
