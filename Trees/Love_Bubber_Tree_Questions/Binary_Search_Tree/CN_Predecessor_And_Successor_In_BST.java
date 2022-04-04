package Trees.Love_Bubber_Tree_Questions.Binary_Search_Tree;


import java.util.ArrayList;

public class CN_Predecessor_And_Successor_In_BST {

    class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

    public static ArrayList<Integer> predecessorSuccessor(TreeNode<Integer> root, int key) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }

        int pred = -1;
        int successor = -1;
        TreeNode<Integer> cur = root;
        // find node
        while (cur.data != key)
        {
            if (key < cur.data)
            {
                successor = cur.data;
                cur = cur.left;
            }
            else if (key > cur.data)
            {
                pred = cur.data;
                cur = cur.right;
            }
        }

        // found key
        // find max not from left sub tree
        TreeNode<Integer> leftTree = cur.left;
        while (leftTree != null)
        {
            pred = leftTree.data;
            leftTree = leftTree.right;
        }

        // find max not from left sub tree
        TreeNode<Integer> rightTree = cur.right;
        while (rightTree != null)
        {
            successor = rightTree.data;
            rightTree = rightTree.left;
        }

        result.add(pred);
        result.add(successor);

        return result;
	}
}
