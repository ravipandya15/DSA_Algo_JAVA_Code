package BinarySearch;

public class Find_Minimum_in_Rotated_Sorted_Array_II_154 {
    public static int findPivot(int[] arr, int n)
    {
        int start = 0;
        int end = n - 1;
        int mid = 0;

        while (start < end)
        {
            while (start + 1 < end && arr[start] == arr[start+1]) start++;
            while (end - 1 > start && arr[end] == arr[end-1]) end--;
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

    public int FindMin(int[] nums) {
        int n = nums.length;
        int pivot = findPivot(nums, n);
        if (pivot - 1 >= 0 && nums[pivot] > nums[pivot - 1])
        {
            return nums[0];
        }
        return nums[pivot];

        
        // int n = nums.length;
        // int end = n - 1;
        // while (end - 1 >= 0 && nums[end] == nums[end-1]) end--;

        // int pivot = findPivot(nums, end+1);
        // if (n > 1 && pivot == end && nums[pivot] > nums[pivot - 1])
        // {
        //     return nums[0];
        // }
        // return nums[pivot];
    }
}
