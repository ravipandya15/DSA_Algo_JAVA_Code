package Trees.Binary_Search_Tree;

public class Binary_Search_Tree_to_Greater_Sum_Tree_1038 {

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

    public static void solve(TreeNode root, int[] prev)
    {
        if (root == null) return;

        solve(root.right, prev);

        root.val += prev[0];
        prev[0] = root.val;

        solve(root.left, prev);
    }

    public TreeNode bstToGst(TreeNode root) {
        int[] prev = {0};
        solve(root, prev);
        return root;
    }
}
