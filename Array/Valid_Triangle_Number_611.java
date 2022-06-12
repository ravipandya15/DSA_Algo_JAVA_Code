package Array;

import java.util.Arrays;

public class Valid_Triangle_Number_611 {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        for (int i = n-1; i >= 2; i--)
        {
            int lo = 0, hi = i-1;
            while (lo < hi)
            {
                if (nums[lo] + nums[hi] > nums[i])
                {
                    ans += (hi - lo);
                    hi--;
                }
                else
                {
                    lo++;
                }
            }
        }
        return ans;
    }
}
