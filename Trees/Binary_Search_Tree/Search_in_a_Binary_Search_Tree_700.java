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

public class Search_in_a_Binary_Search_Tree_700 {
    
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val)
        {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }

}
