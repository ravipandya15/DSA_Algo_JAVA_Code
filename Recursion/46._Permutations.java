package Recursion;
import java.util.ArrayList;
import java.util.List;

class Solution
{
	public static void main(String Args[])
	{
		System.out.println("Allocate Books");
		int[] arr = { 1, 2, 3 };
        var result = Permute(arr);
	}
	
	// Approach 1
	public static void RecurPermute1(int[] nums, boolean[] freq, List<Integer> ds, List<List<Integer>> res)
    {
        // base case
        if (ds.size() == nums.length)
        {
            res.add(new ArrayList<Integer>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if(!freq[i])
            {
                freq[i] = true;
                ds.add(nums[i]);
                RecurPermute1(nums, freq, ds, res);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
	
	// Approach 1
	public static List<List<Integer>> Permute1(int[] nums)
    {
		List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        RecurPermute1(nums, freq, ds, res);
        return res;
    }
	
	// Approach 2
    public static void RecurPermute(int index, int[] nums, List<List<Integer>> ans)
    {
        // base case
        if (index == nums.length)
        {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++)
            {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<Integer>(ds));
            return;
        }

        for (int i = index; i < nums.length; i++)
        {
            Swap(index, i, nums);
            RecurPermute(index + 1, nums, ans);
            Swap(index, i, nums);
        }
    }

    private static void Swap(int i, int j, int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Approach 2
    public static List<List<Integer>> Permute(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        RecurPermute(0, nums, ans);
        return ans;
    }
	
	
}