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

public class Trim_a_Binary_Search_Tree_669 {
    private TreeNode findMaxFromLeftSubTree(TreeNode node)
    {
        while (node.right != null) node = node.right;
        return node;
    }

    private TreeNode helper(TreeNode node)
    {
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;

        TreeNode rootRight = node.right;
        TreeNode maxNodeFromLeftSubTree = findMaxFromLeftSubTree(node.left);

        maxNodeFromLeftSubTree.right = rootRight;
        return node.left;
    }

    private TreeNode recursion(TreeNode node, int low, int high)
    {
        if (node.val < low || node.val > high)
        {
            node = helper(node);
        }

        if (node.left != null)
        {
            node.left = recursion(node.left, low, high);
        }
        if (node.right != null)
        {
            node.right = recursion(node.right, low, high);
        }

        return node;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        
        TreeNode node = root;
        return recursion(node, low, high);
    }

}
