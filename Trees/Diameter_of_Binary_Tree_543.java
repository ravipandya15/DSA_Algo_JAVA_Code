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

public class Diameter_of_Binary_Tree_543 {
    private static int Height(TreeNode root, int[] diameter)
    {
        if (root == null) return 0;

        int lh = Height(root.left, diameter);
        int rh = Height(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        Height(root, diameter);
        return diameter[0];
    }
}
