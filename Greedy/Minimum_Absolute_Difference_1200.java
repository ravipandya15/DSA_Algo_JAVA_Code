package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimum_Absolute_Difference_1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++)
        {
            minDiff = Math.min(minDiff, arr[i] - arr[i-1]);
        }

        for (int i = 1; i < n; i++)
        {
            if (arr[i] - arr[i-1] == minDiff)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                res.add(temp);
            }
        }

        return res;
    }
}
