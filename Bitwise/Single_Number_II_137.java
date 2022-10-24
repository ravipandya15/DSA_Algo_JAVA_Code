package Bitwise;

import java.util.Arrays;

public class Single_Number_II_137 {

    // Method - 2 (Sorting) -> Tc -> O(NLogN)
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 1) return nums[0];
        if (1 < n && nums[0] != nums[1]) return nums[0];
        if (n-2 >= 0 && nums[n-1] != nums[n-2]) return nums[n-1];

        int i = 1;
        while (i < n)
        {
            if (nums[i] == nums[i-1]) i += 3;
            else return nums[i-1];
        }
        return -1;
    }

    // Method - 4 (BIT Manipulation) - TC -> O(N) // considering 
    public int singleNumber_3(int[] nums) {
        int ones = 0, twos = 0;
        for (int el : nums)
        {
            ones = (ones ^ el) & (~twos);
            twos = (twos ^ el) & (~ones);
        }
        return ones;
    }

    // NOT WORKING
    // Method - 3 (Couting SET bits) -> TC -> O(32 * N)
    public int singleNumber_2(int[] nums) {
        int shift = 1, ans = 0;
        for (int i = 0; i < 32; i++)
        {
            int count = 0;
            for (int el : nums)
            {
                if ((el & shift) == 1)
                {
                    count++;
                }
            }
            if (count % 3 != 0)
            {
                ans += shift;
            }
            shift <<= 1;
        }
        return ans;
    }
}
