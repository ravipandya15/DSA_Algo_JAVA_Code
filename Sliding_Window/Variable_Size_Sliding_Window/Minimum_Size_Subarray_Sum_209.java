package Sliding_Window.Variable_Size_Sliding_Window;

public class Minimum_Size_Subarray_Sum_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int count = n;
        int i = 0, j = 0;
        long sum = 0, totalSum = 0;
        while (j < n)
        {
            sum = sum + nums[j];
            totalSum = totalSum + nums[j];
            if (sum < target)
            {
                j++;
            }
            else if (sum == target)
            {
                count = Math.min(count, j - i + 1);
                j++;
            }
            else if (sum > target)
            {
                while (sum >= target)
                {
                    count = Math.min(count, j - i + 1);
                    sum = sum - nums[i];
                    i++;
                }
                j++;
            }
        }
        if (totalSum < target) return 0;
        return count;
    }
}
