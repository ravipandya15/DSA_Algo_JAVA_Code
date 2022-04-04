package Trees.Binary_Search_Tree;

import java.util.ArrayList;

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

class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
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

    private static BinaryTreeNode<Integer> buildBST_2(ArrayList<Integer> preOrder, int lowerBound, int upperBound, int[] i)
    {
        if (i[0] >= preOrder.size() || preOrder.get(i[0]) < lowerBound || preOrder.get(i[0]) > upperBound) 
        {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preOrder.get(i[0]++));
        root.left = buildBST_2(preOrder, lowerBound, root.data, i);
        root.right = buildBST_2(preOrder, root.data, upperBound, i);
        return root;
    }

    // Coding Ninja's Solution
    // can also be done using Lower bound and Upper bound
    public static BinaryTreeNode<Integer> prorderToBST(ArrayList<Integer> preorder) {
		int[] i = {0};
        return buildBST_2(preorder, Integer.MIN_VALUE ,Integer.MAX_VALUE, i);
	}
}
