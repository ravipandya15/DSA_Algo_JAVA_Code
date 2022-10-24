package Array.Tow_Pointer;

public class Rearrange_Array_Elements_by_Sign_2149 {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int index = 0;
        for (int i = 0, j = 0; i < n && j < n; i++, j++)
        {
            while (nums[i] < 0) i++;
            result[index++] = nums[i];

            while (nums[j] > 0) j++;
            result[index++] = nums[j];
        }

        return result;
    }
}
