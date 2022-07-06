package Greedy;

import java.util.Arrays;

public class Remove_Covered_Intervals_1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        int[] tempInterval = intervals[0];
        int res = 1;

        for (int[] i : intervals)
        {
            if (i[0] >= tempInterval[0] && i[1] <= tempInterval[1])
            {
                tempInterval[0] = i[0];
            }
            else
            {
                tempInterval = i;
                res++;
            }
        }

        return res;
    }
}
