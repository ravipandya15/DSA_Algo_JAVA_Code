package Trees.Binary_Search_Tree;

class TreeNode {
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

public class Validate_Binary_Search_Tree_98 {
    
    private static boolean isValidBST(TreeNode root, long minVal, long maxVal)
    {
        if (root == null) return true;

        if (root.val >= maxVal || root.val <= minVal) return false;

        return isValidBST(root.left, minVal, root.val)
            && isValidBST(root.right, root.val, maxVal);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

}
