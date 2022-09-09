package Dynamic_Programming_Series.LIS;

public class Longest_Continuous_Increasing_Subsequence_674 {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int maxi = 1;
        int count = 1;
        for (int i = 1; i < n; i++)
        {
            if (nums[i] > nums[i-1]) 
            {
                count++;
            }
            else
            {
                count = 1;
            }
            maxi = Math.max(maxi, count);
        }
        return maxi;
    }
}
