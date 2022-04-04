package Trees.Love_Bubber_Tree_Questions.Binary_Search_Tree;

import java.util.ArrayList;

class TreeNode<T> 
    {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

public class CN_Normal_BST_To_Balanced_BST {
    
    private static void InOrderTraversal(TreeNode<Integer> root, ArrayList<Integer> inOrder)
    {
        if (root == null)
        {
            return;
        }

        InOrderTraversal(root.left, inOrder);
        inOrder.add(root.data);
        InOrderTraversal(root.right, inOrder);
    }

    private static TreeNode<Integer> inorderToBST(int s, int e, ArrayList<Integer> inOrder)
    {
        if (s > e)
        {
            return null;
        }

        int mid = (s+e)/2;
        TreeNode<Integer> root = new TreeNode<Integer>(inOrder.get(mid));
        root.left = inorderToBST(s, mid-1, inOrder);
        root.right = inorderToBST(mid+1, e, inOrder);

        return root;
    }

    public static TreeNode<Integer> balancedBst(TreeNode<Integer> root)
    {
        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        InOrderTraversal(root, inOrder);

        return inorderToBST(0, inOrder.size() - 1,inOrder);
    }
}
