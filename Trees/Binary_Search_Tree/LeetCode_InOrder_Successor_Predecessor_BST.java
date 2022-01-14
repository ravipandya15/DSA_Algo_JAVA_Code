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

public class LeetCode_InOrder_Successor_Predecessor_BST {
    public static TreeNode inOrder_Successor(TreeNode root, TreeNode p)
    {
        TreeNode successor = null;
        while(root != null)
        {
            if (root.val > p.val)
            {
                successor = root;
                root = root.left;
            }
            else
            {
                root = root.right;
            }
        }
        return successor;
    }

    public static TreeNode inOrder_Predecessor(TreeNode root, TreeNode p)
    {
        TreeNode successor = null;
        while (root != null)
        {
            if (root.val >= p.val) root = root.left;
            else
            {
                successor = root;
                root = root.right;
            }
        }
        return successor;
    }
}
