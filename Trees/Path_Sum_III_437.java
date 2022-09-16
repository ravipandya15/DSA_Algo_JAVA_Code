package Trees;

import java.util.HashMap;
import java.util.Map;

public class Path_Sum_III_437 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void solve(TreeNode root, long sum, int targetSum, Map<Long, Integer> map, int[] count)
    {
        if (root == null) return;

        sum += root.val;
        if (map.containsKey(sum - targetSum))
        {
            count[0] += map.get(sum - targetSum);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        solve(root.left, sum, targetSum, map, count);
        solve(root.right, sum, targetSum, map, count);

        // IMP -> to restore the map. 
        // like backtracking added 1 value of sum to map now we are going back to parent node so need to remove this.
        map.put(sum, map.get(sum) - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        long key = 0;
        map.put(key, 1);
        int[] count = {0};
        solve(root, 0, targetSum, map, count);
        return count[0];
    }
}
