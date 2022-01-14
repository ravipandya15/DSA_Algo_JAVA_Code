package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    
    //code help approach
    //using Recursion
    private static void Solve(int[] nums, int index, List<Integer> output, List<List<Integer>> result)
    {
        if (index >= nums.length)
        {
            result.add(new ArrayList<>(output));
            return;
        }

        // exclude
        Solve(nums, index + 1, output, result);

        //include
        output.add(nums[index]);
        Solve(nums, index + 1, output, result);
        // output ne as a reference pass nathi karyo etle C++ ma remove na lakhiye to chale
        output.remove(output.size()- 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        Solve(nums, 0, output, result);
        return result;
    }

    // Striver approach
    public static void FindSubSet(int index, int[] nums, List<Integer> curList, List<List<Integer>> resultList)
    {
        resultList.add(new ArrayList<>(curList));
        for (int i = index; i < nums.length; i++)
        {
            curList.add(nums[i]);
            FindSubSet(i + 1, nums, curList, resultList);
            curList.remove(curList.size() - 1);
        }
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        FindSubSet(0, nums, curList, resultList);
        return resultList;
    }
}
