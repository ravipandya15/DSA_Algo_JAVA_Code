package BinarySearch;

public class Search_in_Rotated_Sorted_Array_II_81 {

    // Test cases

    // [2,2,2,3,2,2,2]
    // 3
    // [1,0,1,1,1]
    // 0
    public static boolean binarySearch(int[] nums, int start, int end, int target)
    {
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
            {
                return true;
            }
            else if (target > nums[mid])
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return false;
    }

    public static int findPivot(int[] nums, int n)
    {
        int start = 0, end = n - 1;
        while (start < end)
        {
            while (start + 1 < end && nums[start] == nums[start + 1]) start++;
            while (end - 1 > start && nums[end] == nums[end - 1]) end--;
            int mid = start + (end - start) / 2;
            if (nums[mid] >= nums[0]) // first part is sorted
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

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums, n);
        if (target >= nums[pivot] && target <= nums[n-1])
        {// B.S on 2nd line
            return binarySearch(nums, pivot, n - 1, target);
        }
        else
        {// B.S on 1st line
            return binarySearch(nums, 0, pivot - 1, target);
        }
    }
}
