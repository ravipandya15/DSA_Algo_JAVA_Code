package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class Continuous_Subarray_Sum_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int total = 0;
        int reminder = 0;
        for (int i = 0; i < nums.length; i++)
        {
            total += nums[i];
            reminder = total % k;
            if (!map.containsKey(reminder))
            {
                map.put(reminder, i);
            }
            else if (i - map.get(reminder) >= 2)
            {
                return true;
            }
        }
        return false;
    }
}
