package Trees;

public class Sum_of_Left_Leaves_404 {
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

    public static void solve(TreeNode root, int[] sum, boolean flag)
    {
        if (root == null) return;

        if (root.left == null && root.right == null && flag) sum[0] += root.val;

        solve(root.left, sum, true);
        solve(root.right, sum, false);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = {0};
        solve(root, sum, false);
        return sum[0];
    }
}
