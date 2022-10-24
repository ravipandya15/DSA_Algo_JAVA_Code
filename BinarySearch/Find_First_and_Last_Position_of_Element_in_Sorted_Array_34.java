package BinarySearch;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array_34 {

    public static int findFirst(int s, int e, int[] nums, int target)
    {
        int ans = -1;
        int mid = s + (e - s) / 2;
        while (s <= e)
        {
            if (nums[mid] == target)
            {
                ans = mid;
                e = mid - 1;
            }
            else if (nums[mid] > target)
            {
                e = mid - 1;
            }
            else
            {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }

    public static int findLast(int s, int e, int[] nums, int target)
    {
        int ans = -1;
        int mid = s + (e - s) / 2;
        while (s <= e)
        {
            if (nums[mid] == target)
            {
                ans = mid;
                s = mid + 1;
            }
            else if (nums[mid] > target)
            {
                e = mid - 1;
            }
            else
            {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[] {-1, -1};
        ans[0] = findFirst(0, n - 1, nums, target);
        ans[1] = findLast(0, n - 1, nums, target);
        return ans;
    }

    // it takes more time (just for learning)
    // if interviewer ask for only 1 binary search
    public int[] searchRange_1(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[] {-1, -1};

        int s = 0, e = n - 1;
        int mid = s + (e - s) / 2;
        while (s <= e)
        {
            if (nums[mid] == target)
            {
                s = mid - 1;
                e = mid + 1;

                while (s >= 0 && nums[s] == target) s--;
                ans[0] = s + 1;

                while (e < n && nums[e] == target) e++;
                ans[1] = e - 1;
                return ans;
            }
            else if (nums[mid] > target)
            {
                e = mid - 1;
            }
            else
            {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }
}
