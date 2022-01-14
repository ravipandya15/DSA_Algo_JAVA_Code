package Trees;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // this will also work
        //if (left != null && right != null) return root;
        //else if (left != null) return left;
        //else return right;

        if (left == null) return right;
        else if (right == null) return left;
        else
        { // both left and right are not null, we found our ans
            return root;
        }
    }

}
