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

public class Delete_Node_in_a_BST_450 {
    
    private static TreeNode findLastNodeInLeftSubTree(TreeNode root)
    {
        if (root.right == null) return root;
        return findLastNodeInLeftSubTree(root.right);
    }

    private static TreeNode helper(TreeNode root)
    {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        // means both left and right part exist;
        // task is to find last node is left sub tree and right of that should be root.right;

        TreeNode rightChild = root.right;
        TreeNode lastNodeInLeftSubTree = findLastNodeInLeftSubTree(root.left);
        lastNodeInLeftSubTree.right = rightChild;
        return root.left;
    }

    // TC -> O(logN) -> Log N base 2
    // SC -> O(1)
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) return helper(root);
        TreeNode dummy = root;

        while (root != null)
        {
            if (root.val > key)
            {// go left side
                if (root.left != null && root.left.val == key)
                {
                    root.left = helper(root.left);
                    break;
                }
                else
                {
                    root = root.left;
                }
            }
            else
            {// go ti right side
                if (root.right != null && root.right.val == key)
                {
                    root.right = helper(root.right);
                    break;
                }
                else
                {
                    root = root.right;
                }
            }
        }
        return dummy;
    }

}
