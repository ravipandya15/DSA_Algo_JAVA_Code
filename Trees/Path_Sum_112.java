package Trees;

public class Path_Sum_112 {
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

    public static boolean solve(TreeNode root, int sum, int target)
    {
        if (root == null) return false;
        if (root.left == null && root.right == null)
        {
            if (sum + root.val == target) return true;
            else return false;
        }
        boolean left = solve(root.left, sum + root.val, target);
        if (left) return true;
        boolean right = solve(root.right, sum + root.val, target);
        if (right) return true;
        return false;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, 0, targetSum);
    }
}
