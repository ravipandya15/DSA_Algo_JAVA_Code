package BinarySearch;

class LeetCode
{
	public static void main (String[] args) {
		System.out.println("540. Single Element in a Sorted Array");
		int[] arr = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		System.out.println("value is " + SingleNonDuplicate(arr));
	}
	
	// TC -> O(N)
    // SC -> O(1)
    public static int SingleNonDuplicate(int[] nums)
    {
        int low = 0;
        int high = nums.length - 2;

        while (low <= high)
        {
            int mid = (low + high) >> 1;
            if (nums[mid] == nums[mid ^ 1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return nums[low];
    }
}