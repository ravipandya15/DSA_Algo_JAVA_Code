package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

public class Wiggle_Subsequence_376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int prevInd = 0;
        int prev = nums[1] - nums[0];
        int count = 1;
        if (prev != 0)
        {
            count = 2;
            prevInd = 1;
        }
        for (int i = 2; i < n; i++)
        {
            int diff = nums[i] - nums[prevInd];
            // prev >= 0, prev <= 0 required for test case [3, 3, 3, 2, 5]
            if ((diff < 0 && prev >= 0) || (diff > 0 && prev <= 0))
            {
                count++;
                prevInd = i;
                prev = diff;
            }
            else if (prev >= 0 && nums[i] > nums[prevInd])
            {
                prevInd = i;
                prev += nums[i] - nums[prevInd];
            }
            else if (prev <= 0 && nums[i] < nums[prevInd])
            {
                prevInd = i;
                prev -= nums[i] - nums[prevInd]; 
            }
        }
        return count;
    }
}
