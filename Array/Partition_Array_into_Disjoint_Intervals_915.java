package Array;

public class Partition_Array_into_Disjoint_Intervals_915 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int mini = 0, maxi = 0;
        for (int i = 0; i < n; i++)
        {
            if (nums[i] > nums[maxi]) maxi = i;
            if (nums[i] < nums[mini]) mini = i;
        }
        int rightMin = maxi;
        for (int i = maxi + 1; i < n; i++)
        {
            if (nums[i] < nums[rightMin]) rightMin = i;
        }

        int i = mini;
        while (i < maxi)
        {
            if (nums[i] <= nums[rightMin]) i++;
            else break;
        }
        return i;
    }
}
