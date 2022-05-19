package Array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Shift_2D_Grid_1260 {

    private static void reverse(int[] arr, int first, int last)
    {
        while (first <= last)
        {
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;
            first++;
            last--;
        }
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[] temp = new int[m*n];
        int count = 0;
        
        for (int r = 0; r < m; r++)
        {
            for (int c = 0; c < n; c++)
            {
                temp[count] = grid[r][c];
            }
        }
        k = k % m*n;

        reverse(temp, 0, m*n - 1);
        reverse(temp, 0, k-1);
        reverse(temp, k, m*n - 1);
        List<Integer> temp2 = new ArrayList<Integer>();

        for (int i = 0; i < m*n-1; i++)
        {
            temp2.add(temp[i]);
            if (i + 1 % m == 0)
            {
                result.add(temp2);
                temp2 = new ArrayList<Integer>();
            }
        }

        return result;
    }
}
