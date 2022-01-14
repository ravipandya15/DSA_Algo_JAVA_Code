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

public class Insert_into_a_Binary_Search_Tree_701 {
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode cur = root;

        while (true)
        {
            // if (cur.val < val) will also work
            if (cur.val <= val)
            {
                if (cur.right != null) 
                    cur = cur.right;
                else
                {
                    cur.right = new TreeNode(val);
                    break; // IMP -> otherwise infinite loop
                }
            }
            else
            {
                if (cur.left != null)
                    cur = cur.left;
                else
                {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

}
