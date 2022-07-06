package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Minimum_Number_of_Arrows_to_Burst_Balloons_452 {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (points.length == 0) return 0;

        Arrays.sort(points, new Comparator<int[]>() {

            @Override
            public int compare(int[] a, int[] b)
            {
                if (b[1] < a[1]) return 1;
                return -1;
            }
        }); // what if we compare based on starting index?
        int end = points[0][1];
        int arrows = 1;

        for (int i = 1; i < n; i++)
        {
            if (points[i][0] > end)
            {
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }
}
