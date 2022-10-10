package Array.Tow_Pointer;

public class Remove_Element_27 {

    public int removeElement_1(int[] nums, int val) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            if (nums[i] != val) count++;
        }
        int j = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++)
        {
            if (nums[i] == val)
            {
                if (flag == true) continue;
                else
                {
                    j = i;
                    flag = true;
                }
            }
            if (flag == true)
            {
                nums[j] = nums[i];
                j++;
            }
        }

        return count;
    }

    public int removeElement_2(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != val)
            {
                nums[k] = nums[i];
                k++; 
            }
        }
        return k;
    }

    public int removeElement_3(int[] nums, int val) {
        int n = nums.length;
        int start = 0, end = n - 1;
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            if (nums[i] != val) count++;
        }
        while (start < end)
        {
            while (end - 1 >= 0 && nums[end] == val) end--;
            while (start + 1 < n && nums[start] != val) start++;
            if (start < end)
            {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
            start++;
            end--;
        }
        return count;
    }
}
