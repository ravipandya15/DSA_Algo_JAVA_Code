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


public class Construct_Binary_Search_Tree_from_Preorder_Traversal_1008 {
    
    // bound is upper bound, value should not be greater than or equal to bound
    private static TreeNode buildBST(int[] preOrder, int bound, int[] i)
    {
        if (i[0] == preOrder.length || preOrder[i[0]] > bound) return null;
        TreeNode root = new TreeNode(preOrder[i[0]++]);
        root.left = buildBST(preOrder, root.val, i);
        root.right = buildBST(preOrder, bound, i);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] i = {0};
        return buildBST(preorder, Integer.MAX_VALUE, i);
    }

}
