package Trees;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II_113 {
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

    public static void solve(TreeNode root, int sum, int target, List<Integer> ans, List<List<Integer>> result)
    {
        if (root == null) return;
        if (root.left == null && root.right == null)
        {
            if (sum + root.val == target)
            {
                ans.add(root.val);
                result.add(new ArrayList<>(ans));
                ans.remove(ans.size() - 1);
                return;
            }
            else return;
        }

        ans.add(root.val);
        solve(root.left, sum + root.val, target, ans, result);
        solve(root.right, sum + root.val, target, ans, result);
        ans.remove(ans.size() - 1);
        return;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        solve(root, 0, targetSum, ans, result);
        return result;
    }
}
