package Array.Tow_Pointer;

import java.util.ArrayList;
import java.util.List;

public class Intersection_of_Multiple_Arrays_2248 {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int[] count = new int[1001];

        for (int[] arr : nums)
        {
            for (int i : arr)
            {
                count[i]++;
            }
        }

        for (int i = 0; i < 1001; i++)
        {
            if (count[i] == n)
            {
                list.add(i);
            }
        }
        return list;
    }
}
