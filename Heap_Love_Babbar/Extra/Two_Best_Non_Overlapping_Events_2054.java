package Heap_Love_Babbar.Extra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Two_Best_Non_Overlapping_Events_2054 {

    public class Data
    {
        int start;
        int end;
        int value;

        public Data() {}
        public Data(int start, int end, int value)
        {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        // sort based on starting time -> if same, based on ending time
        Arrays.sort(events, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2)
            {
                if (a1[0] == a2[0])
                {
                    return a1[1] - a2[1];
                }
                else return a1[0] - a2[0];
            }
        });

        // put data in PQ based on ending time -> if same, based on starting time
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            new Comparator<int[]>() {
                public int compare(int[] d1, int[] d2)
                {
                    if (d1[1] == d2[1])
                    {
                        return d1[0] - d2[0];
                    }
                    else return d1[1] - d2[1];
                }
            });
        
        int maxi = 0;
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            while (!pq.isEmpty() && pq.peek()[1] < events[i][0])
            {
                maxi = Math.max(maxi, pq.peek()[2]);
                pq.poll();
            }
            ans = Math.max(ans, maxi + events[i][2]);
            pq.add(events[i]);
        }
        return ans;
    }

    public static int findIndex(int start, int end, int[][] events, int current)
    {
        int mid = start + (end - start) / 2;
        //int ans = start;
        while (start <= end)
        {
            if (events[mid][0] > events[current][1])
            {
                //ans = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return start;

        // BELOW CODE IS NOT WORKING

        // int mid = start + (end - start) / 2;
        // //int ans = start;
        // while (start <= end)
        // {
        //     if (events[mid][0] > events[current][1])
        //     {
        //         //ans = mid;
        //         end = mid - 1;
        //     }
        //     else
        //     {
        //         start = mid + 1;
        //     }
        //     mid = start + (end - start) / 2;
        // }
        // return ans;
    }

    public static int solve(int index, int jobCount, int[][] events, int n, int[][] dp)
    {
        // base case
        if (index >= n || jobCount == 2) return 0;

        if (dp[index][jobCount] != -1) return dp[index][jobCount];

        // pick
        int nextIndex = findIndex(index + 1, n, events, index);
        int pick = events[index][2] + solve(nextIndex, jobCount + 1, events, n, dp);

        // non - pick
        int nonPick = solve(index + 1, jobCount, events, n, dp);

        return dp[index][jobCount] = Math.max(pick, nonPick);
    }

    // Dynamic programming
    public int maxTwoEvents_1(int[][] events) {
        int n = events.length;

        // sort based on starting time -> if same, based on ending time
        Arrays.sort(events, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2)
            {
                if (a1[0] == a2[0])
                {
                    return a1[1] - a2[1];
                }
                else return a1[0] - a2[0];
            }
        });
        int[][] dp = new int[n+1][3];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(0, 0, events, n, dp);
    }
}
