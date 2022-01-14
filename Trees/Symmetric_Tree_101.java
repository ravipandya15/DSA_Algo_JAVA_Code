package Trees;
class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class Symmetric_Tree_101 {
    private static boolean isSymmetrichelp(TreeNode left, TreeNode right)
    {
        if (left == null || right == null) return (left == right);

        if (left.val != right.val) return false;

        return isSymmetrichelp(left.left, right.right) && isSymmetrichelp(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return (root == null) || isSymmetrichelp(root.left, root.right);
    }
}
