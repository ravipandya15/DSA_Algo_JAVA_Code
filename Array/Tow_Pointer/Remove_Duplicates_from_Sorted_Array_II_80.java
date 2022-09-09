package Array.Tow_Pointer;

public class Remove_Duplicates_from_Sorted_Array_II_80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int i = 0;
        int j = 1;
        int count = 1;
        while (i < nums.length && j < nums.length) // only j < nums.length is enough
        {
            if (nums[i] == nums[j] && count >= 2)
            {
                j++;
                count++;
            }
            else
            {
                if (nums[i] == nums[j])
                {
                    count++;
                    i++;
                    nums[i] = nums[j];
                    j++;
                }
                else
                {
                    i++;
                    nums[i] = nums[j];
                    j++;
                    count = 1;
                }   
            }
        }

        return i + 1;
    }
}
