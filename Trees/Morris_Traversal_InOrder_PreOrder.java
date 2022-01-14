package Trees;

import java.util.ArrayList;
import java.util.List;

class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Morris_Inorder
// TC -> O(N), SC -> O(1)
public class Morris_Traversal_InOrder_PreOrder {
    
    public List<Integer> morris_Inorder(TreeNode root) {
        // Morris_Inorder
        // TC -> O(N), SC -> O(1)
        List<Integer> morris_Inorder = new ArrayList<Integer>();
        TreeNode cur = root;
        while (cur != null)
        {
            if (cur.left == null)
            {
                morris_Inorder.add(cur.val);
                cur = cur.right;
            }
            else
            {
                // go to right most down most node of left subtree
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur)
                {
                    prev = prev.right;
                }

                if (prev.right == null)
                {
                    // make pointer pointer
                    prev.right = cur;
                    cur = cur.left;
                }
                else
                {
                    // means prev.right == cur
                    prev.right = null;
                    morris_Inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return morris_Inorder;
    }

    // Morris_Preorder
    // TC -> O(N), SC -> O(1)
    public List<Integer> morris_Preorder(TreeNode root) {
        // Morris_Preorder
        // TC -> O(N), SC -> O(1)
        List<Integer> morris_Preorder = new ArrayList<Integer>();
        TreeNode cur = root;
        while (cur != null)
        {
            if (cur.left == null)
            {
                morris_Preorder.add(cur.val);
                cur = cur.right;
            }
            else
            {
                // go to right most down most node of left subtree
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur)
                {
                    prev = prev.right;
                }

                if (prev.right == null)
                {
                    // make pointer pointer
                    prev.right = cur;
                    morris_Preorder.add(cur.val);
                    cur = cur.left;
                }
                else
                {
                    // means prev.right == cur
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return morris_Preorder;
    }
    
}
