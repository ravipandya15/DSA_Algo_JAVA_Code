package Sliding_Window.Fixed_Sized_Sliding_Window;

import java.util.Arrays;

public class K_Radius_Subarray_Averages_2090 {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        int i = 0, j = 0;
        int[] ans = new int[n];
        if (n < 2*k + 1)
        {
            Arrays.fill(ans, -1);
            return ans;
        }
        while (j < n)
        {
            sum = sum + nums[j];
            if (j - 2* k < 0)
            {
                if (j - k >= 0) ans[j-k] = -1;
                j++;
            }
            else if (j - 2 * k >= 0)
            {
                ans[j - k] = (int)(sum / (j - i + 1));
                sum = sum - nums[i];
                i++;
                j++;
            }
        }
        while ((j - k) < n && (j - k) >= 0)
        {
            ans[j - k] = -1;
            j++;
        }
        return ans;
    }
}
