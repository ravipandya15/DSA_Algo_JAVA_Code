package Trees.Binary_Search_Tree;

class NodeValue
{
    public int minNode, maxNode, maxSize;
    public NodeValue(int minNode, int maxNode, int maxSize)
    {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }
}

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

public class LeetCode_Largest_BST_In_Binary_Tree {
    
    private static NodeValue LargestBSTSubTReeHelper(TreeNode root)
    {
        if (root == null) return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeValue left = LargestBSTSubTReeHelper(root.left);
        NodeValue right = LargestBSTSubTReeHelper(root.right);

        if (left.maxNode < root.val && root.val < right.minNode)
        {
            // it is a BST
            return new NodeValue(Math.min(root.val, left.minNode),
                                    Math.max(root.val, right.maxNode),
                                    left.maxSize + right.maxSize + 1);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    public int LargestBSTSubTree(TreeNode root)
    {
        return LargestBSTSubTReeHelper(root).maxSize;
    }

}
