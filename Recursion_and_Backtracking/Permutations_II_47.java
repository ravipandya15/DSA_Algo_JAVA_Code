package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations_II_47 {

    public void swap(int i, int j, int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void solve(List<List<Integer>> result, List<Integer> ans, Map<Integer, Integer> map, int n)
    {
        // base case
        if (ans.size() == n)
        {
            result.add(new ArrayList<>(ans));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (entry.getValue() > 0)
            {
                int i = entry.getKey();
                ans.add(i);
                map.put(i, map.get(i) - 1);

                solve(result, ans, map, n);

                map.put(i, map.get(i) + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        solve(result, ans, map, n);
        
        return result;
    }

    public void solve_1(int index, List<List<Integer>> result, int[] nums, int n)
    {
        // base case
        if (index == n)
        {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++)
            {
                ans.add(nums[i]);
            }
            result.add(ans);
            return;
        }

        for (int i = index; i < n; i++)
        {
            if (i != index && (nums[i] == nums[i-1] || nums[i] == nums[index])) continue;

            swap(index, i , nums);
            solve_1(index + 1, result, nums, n);
            swap(index, i , nums);
        }
    }
    public List<List<Integer>> permuteUnique_1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        solve_1(0, result, nums, nums.length);

        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < result.size(); i++)
        {
            map.put(result.get(i), map.getOrDefault(result.get(i), 0) + 1);
        }

        for (Map.Entry<List<Integer>, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        return result;
    }
}
