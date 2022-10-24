package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Non_overlapping_Intervals_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] a1, int[] a2)
            {
                return a1[1] - a2[1];
            }
        });

        int n = intervals.length;
        int ans = 0;
        int[] firstInterval = intervals[0];
        for (int i = 1; i < n; i++)
        {
            if (intervals[i][0] < firstInterval[1])
            {
                ans++;
            }
            else
            {
                firstInterval = intervals[i];
            }
        }
        return ans;
    }
}
