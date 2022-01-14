package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Segment
{
    int start, end;
    Segment(int x, int y)
    {
        start = x;
        end = y;
    }
}

public class Ninja_Technique {
    
    public static int ninjaTechnique(int n, int[][] a) {
        

        for (int i = 0; i < n; i++)
        {
            if (a[i][0] > a[i][1])
            {
                int temp = a[i][0];
                a[i][0] = a[i][1];
                a[i][1] = temp;
            }
        }

        Segment[] arr = new Segment[n];

        for (int i = 0; i < n; i++)
        {
            arr[i] = new Segment(a[i][0], a[i][1]);
        }

        // Arrays.sort(a, new java.util.Comparator<int[]>() {
        //     public int compare(int[] a, int[] b) {
        //         return Double.compare(a[0], b[0]);
        //     }
        // });
        Arrays.sort(arr, Comparator.comparingInt(x->x.end));

        int prev = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i].start > prev)
            {
                prev = arr[i].end;
                ans++;
            }
        }

        return ans;
    }
}
