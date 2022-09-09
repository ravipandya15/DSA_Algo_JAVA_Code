package Trees.Binary_Search_Tree;

public class Minimum_Absolute_Difference_in_BST_530 {

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
    
    public static void solve(TreeNode root, int[] res, int[] pre)
    {
        if (root.left != null) solve(root.left, res, pre);
        if (pre[0] >= 0) res[0] = Math.min(res[0], root.val - pre[0]);
        pre[0] = root.val;
        if (root.right != null) solve(root.right, res, pre);
    }

    public int getMinimumDifference(TreeNode root) {
        int[] res = {Integer.MAX_VALUE};
        int[] pre = {-1};
        solve(root, res, pre);
        return res[0];
    }
}
