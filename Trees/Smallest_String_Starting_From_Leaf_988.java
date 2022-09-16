package Trees;

public class Smallest_String_Starting_From_Leaf_988 {
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

    public String solve(TreeNode root, String suffix)
    {
        if (root == null) return suffix;
        suffix = (char)('a' + root.val) + suffix;
        if (root.left == null && root.right == null)
        {
            return suffix;
        }
        String left = solve(root.left, suffix);
        String right = solve(root.right, suffix);
        if (root.left == null)
        {
            return right;
        }
        else if (root.right == null)
        {
            return left;
        }

        if (left.compareTo(right) > 0) return right;
        else return left;
    }

    public String smallestFromLeaf(TreeNode root) {
        return solve(root, "");
    }
}
