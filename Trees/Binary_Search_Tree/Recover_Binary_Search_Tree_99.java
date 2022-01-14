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


class Recover_Binary_Search_Tree_99 {

    private TreeNode first, middle, last, prev;

    private void InOrder(TreeNode root)
    {
        if (root == null) return;

        InOrder(root.left);

        if (prev != null && root.val < prev.val)
        {
            // if this is first violation mark these two nodes as first and middle
            if (first == null)
            {
                first = prev;
                middle = root;
            }
            else
            {// if this is second violation mark this as last.
                last = root;
            }
        }

        prev = root;
        InOrder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        InOrder(root);
        if (first != null && last != null)
        {
            // swap first and last value
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if (first != null && middle != null)
        {
            // swap first and middle value
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
    
}
