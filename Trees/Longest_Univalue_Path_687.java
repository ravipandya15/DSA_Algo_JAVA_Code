package Trees;

public class Longest_Univalue_Path_687 {
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

    public static int solve(TreeNode root, int[] maxi)
    {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;

        int left = solve(root.left, maxi);
        int right = solve(root.right, maxi);

        int count = 0;
        if (root.left != null && root.val == root.left.val)
        {
            count += left + 1;
        }
        else
        {
            left = 0;
        }
        if (root.right != null && root.val == root.right.val)
        {
            count += right + 1;
        }
        else
        {
            right = 0;
        }
        maxi[0] = Math.max(maxi[0], count);
        return Math.max(left + 1, right + 1);
    }

    public int longestUnivaluePath(TreeNode root) {
        int[] maxi = {0};
        solve(root, maxi);
        return maxi[0];
    }
}
