package Array;

import java.util.Arrays;

public class Maximum_Product_of_Three_Numbers_628 {

    // TC -> O(n)
    // Sc -> O(1)
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int num : nums)
        {
            if (num <= min1) // till now number is minimum
            {
                min2 = min1;
                min1 = num;
            }
            else if (num <= min2) // num lies between min1 and min2
            {
                min2 = num;
            }
            if (num >= max1) // till now number is maximun
            {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if (num >= max2) // number is between max1 and max2
            {
                max3 = max2;
                max2 = num;
            }
            else if (num >= max3) // number is between max2 and max3
            {
                max3 = num;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
    
    // TC -> O(nlogn)
    // Sc -> O(1)
    public int maximumProduct_1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[n-1] * nums[n-2] * nums[n-3] , nums[0] * nums[1] * nums[n-1]);
    }
}
