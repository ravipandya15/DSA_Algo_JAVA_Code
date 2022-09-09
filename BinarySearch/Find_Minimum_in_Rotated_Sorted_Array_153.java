package BinarySearch;

public class Find_Minimum_in_Rotated_Sorted_Array_153 {
    public static int findPivot(int[] arr, int n)
    {
        int start = 0;
        int end = n - 1;
        int mid = 0;

        while (start < end)
        {
            mid = start + (end - start) / 2;
            if (arr[mid] >= arr[0])
            {
                start = mid + 1;
            }
            else
            {
                end = mid;
            }
        }
        return start;
    }
    
    public int findMin(int[] nums) {
        int n = nums.length;
        int pivot = findPivot(nums, n);
        if (pivot - 1 >= 0 && nums[pivot] > nums[pivot - 1])
        {
            return nums[0];
        }
        // if (n > 1 && pivot == n-1 && nums[pivot] > nums[pivot - 1])
        // {
        //     return nums[0];
        // }
        return nums[pivot];
    }
}
