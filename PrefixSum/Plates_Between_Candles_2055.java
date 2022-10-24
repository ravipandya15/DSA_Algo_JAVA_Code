package PrefixSum;

import java.util.ArrayList;
import java.util.List;

public class Plates_Between_Candles_2055 {

    public static int lower_bound(int l, int r, int data, List<Integer> list)
    {
        int mid = l + (r - l) / 2;

        while (l <= r)
        {
            if (list.get(mid) == data) return mid;
            if (list.get(mid) < data)
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
            mid = l + (r - l) / 2;
        }
        return l;
    }

    public static int upper_bound(int l, int r, int data, List<Integer> list)
    {
        int mid = l + (r - l) / 2;

        while (l <= r)
        {
            if (list.get(mid) == data) return mid + 1;
            if (list.get(mid) < data)
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
            mid = l + (r - l) / 2;
        }
        return l;
    }

    // TC -> O(N + Q* (2 * Log(N)))
    // SC -> O(N) -> worst case
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int m = queries.length;
        int[] ans = new int[m];
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < n; i++)
        {
            if (s.charAt(i) == '|') list.add(i);
        }
        int end = list.size();

        for (int i = 0; i < m; i++)
        {
            int l = queries[i][0];
            int r = queries[i][1];

            int first = lower_bound(0, end - 1, l, list);
            int last = upper_bound(0, end - 1, r, list) - 1;

            if (last <= first) ans[i] = 0;
            else
            {
                ans[i] = list.get(last) - list.get(first) - (last - first);
            }
        }
        return ans;
    }

    // TC -> O(2N + Q)
    // SC -> O(3*N)
    public int[] platesBetweenCandles_1(String s, int[][] queries) {
        int n = s.length();
        int m = queries.length;
        int[] ans = new int[m];
        int[] next = new int[n];
        int[] prev = new int[n];
        int[] prefixSum = new int[n];

        for (int i = 0; i < n; i++)
        {
            if (i == 0)
            {
                if (s.charAt(i) == '|')
                {
                    prev[i] = i;
                    prefixSum[i] = 0;
                }
                else
                {
                    prev[i] = -1;
                    prefixSum[i] = 1;
                }
            }
            else
            {
                if (s.charAt(i) == '|')
                {
                    prev[i] = i;
                    prefixSum[i] = prefixSum[i-1];
                }
                else
                {
                    prev[i] = prev[i-1];
                    prefixSum[i] = 1 + prefixSum[i-1];
                }
            }
        }

        for (int i = n-1; i >= 0; i--)
        {
            if (i == n-1)
            {
                if (s.charAt(i) == '|')
                {
                    next[i] = i;
                }
                else
                {
                    next[i] = -1;
                }
            }
            else
            {
                if (s.charAt(i) == '|')
                {
                    next[i] = i;
                }
                else
                {
                    next[i] = next[i+1];
                }
            }
        }

        for (int i = 0; i < m; i++)
        {
            int l = queries[i][0];
            int r = queries[i][1];

            int first = next[l];
            int last = prev[r];

            if (last <= first || last == -1 || first == -1) ans[i] = 0;
            else
            {
                ans[i] = prefixSum[last] - prefixSum[first];
            }
        }
        return ans;
    }
}
