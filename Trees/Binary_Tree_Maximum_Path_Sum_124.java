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

public class Binary_Tree_Maximum_Path_Sum_124 {

    public static void main(String[] args)
    {
        System.out.println("124. Binary Tree Maximum Path Sum");
    }

    private static int maxPathDown(TreeNode node, int[] maxi)
    {
        if (node == null) return 0;

        // value might be -ve, so better not to take it. so 0 is default value.
        int leftSum = Math.max(0, maxPathDown(node.left, maxi));
        int rightSum = Math.max(0, maxPathDown(node.right, maxi));

        maxi[0] = Math.max(maxi[0], node.val + leftSum + rightSum);

        return node.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxi);
        return maxi[0];
    }
}
