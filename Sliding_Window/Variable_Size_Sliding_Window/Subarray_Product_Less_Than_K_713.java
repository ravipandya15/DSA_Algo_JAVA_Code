package Sliding_Window.Variable_Size_Sliding_Window;

public class Subarray_Product_Less_Than_K_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        long product = 1;
        int i = 0, j = 0;
        int count = 0;
        while (j < n)
        {
            product *= nums[j];
            while (i <= j && product >= k)
            {
                product /= nums[i];
                i++;
            }
            count += (j - i + 1);
            j++;
        }
        return count;
    }
}
