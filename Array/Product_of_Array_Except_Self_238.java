package Array;

public class Product_of_Array_Except_Self_238 {

    // TC -> O(N)
    // Sc -> O(1)
    public int[] productExceptSelf_1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
        {
            if (i == 0) result[i] = 1;
            else
            {
                result[i] = result[i - 1] * nums[i - 1];
            }
        }

        int right = 1;
        for (int i = n-1; i >= 0; i--)
        {
            result[i] = result[i] * right;
            right = right * nums[i];
        }
        return result;
    }

    // TC -> O(N)
    // Sc -> O(N)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans1 = new int[n];
        int[] ans2 = new int[n];

        for (int i = 0; i < n; i++)
        {
            if (i == 0) ans1[i] = 1;
            else
            {
                ans1[i] = ans1[i - 1] * nums[i - 1];
            }
        }

        for (int i = n-1; i >= 0; i--)
        {
            if (i == (n-1)) ans2[i] = 1;
            else
            {
                ans2[i] = ans2[i + 1] * nums[i + 1];
            }
        }
        
        for (int i = 0; i < n; i++)
        {
            ans2[i] = ans2[i] * ans1[i];
        }
        return ans2;
    }
}
