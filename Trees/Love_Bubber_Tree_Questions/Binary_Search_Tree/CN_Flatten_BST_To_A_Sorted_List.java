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

public class CN_Flatten_BST_To_A_Sorted_List {
    
    public static void InOrderTraversal(TreeNode<Integer> root, ArrayList<Integer> inOrder)
    {
        if (root == null)
        {
            return;
        }

        InOrderTraversal(root.left, inOrder);
        inOrder.add(root.data);
        InOrderTraversal(root.right, inOrder);
    }

    public static TreeNode<Integer> flatten(TreeNode<Integer> root)
    {
        // min. ek node to hase j
        // as N >= 1
        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        InOrderTraversal(root, inOrder);

        TreeNode<Integer> newNode = new TreeNode<Integer>(inOrder.get(0));
        TreeNode<Integer> cur = newNode;

        for (int i = 1; i < inOrder.size(); i++)
        {
            TreeNode<Integer> temp = new TreeNode<Integer>(inOrder.get(i));
            cur.left = null;
            cur.right = temp;
            cur = temp;
        }

        // for last node
        cur.left = null;
        cur.right = null;
        return newNode;
    }
}
