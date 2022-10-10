package Sliding_Window.Variable_Size_Sliding_Window;

import java.util.HashMap;

public class Maximum_Erasure_Value_1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int currSum = 0;
        int maxSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0, j = 0; j < n; j++) 
        {
            while (map.containsKey(nums[j]))
            {
                currSum -= nums[i];
                map.remove(nums[i]);
                i++;
            }
            
            currSum += nums[j];
            map.put(nums[j], 1);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    // this will also work
    public int maximumUniqueSubarray_1(int[] nums) {
        int n = nums.length;
        int currSum = 0;
        int maxSum = 0;
        int i = 0, j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (j < n)
        {
            if (!map.containsKey(nums[j]))
            {
                currSum += nums[j];
                map.put(nums[j], 1);
                maxSum = Math.max(maxSum, currSum);
                j++;
            }
            else
            {
                while (map.containsKey(nums[j]))
                {
                    currSum -= nums[i];
                    map.remove(nums[i]);
                    i++;
                }
                currSum += nums[j];
                map.put(nums[j], 1);
                maxSum = Math.max(maxSum, currSum);
                j++;
            }
        }

        return maxSum;
    }
}
