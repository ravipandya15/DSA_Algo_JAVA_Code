package Trees.Binary_Search_Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
    
public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Recrsive
        if (root == null) return null;
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestor_Iterative(TreeNode root, TreeNode p, TreeNode q) {
        //Iterative
        while (root != null)
        {
            if (p.val > root.val && q.val > root.val)
            {
                root = root.right;
            }
            else if (p.val < root.val && q.val < root.val)
            {
                root = root.left;
            }
            else
            {
                return root;
            }
        }
        return root;
    }

}
