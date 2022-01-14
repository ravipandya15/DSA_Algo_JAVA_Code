package Trees;

import java.util.Stack;

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

public class Flatten_Binary_Tree_to_Linked_List_114 {
    
    // Approach - 1
    // Recursive
    // TC -> O(N), SC -> O(N)
    TreeNode prev = null;
    public void flatten1(TreeNode root) {
        // Approach - 1
        // Recursive
        // TC -> O(N), SC -> O(N)
        if (root == null) return;

        flatten1(root.right);
        flatten1(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    // Approach -2 
    // Iterative
    // TC -> O(N), SC -> O(N)
    public void flatten2(TreeNode root) {
        // Approach -2 
        // Iterative
        // TC -> O(N), SC -> O(N)
        if (root == null) return;
        // we can also use Deque -> can push and pop from both the end
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.add(root);

        while (!st.isEmpty())
        {
            TreeNode cur = st.peek();
            st.pop();

            if (cur.right != null) st.add(cur.right);
            if (cur.left != null) st.add(cur.left);

            if (!st.isEmpty()) cur.right = st.peek();
            cur.left = null;
        }
    }

    // Approach - 3 
    // Morris Traversal
    // TC -> O(N), SC -> O(1)
    public void flatten3_Morris_Traversal(TreeNode root) {
        // Approach - 3 
        // Morris Traversal
        // TC -> O(N), SC -> O(1)
        while (root != null)
        {
            if (root.left != null)
            {
                TreeNode prev = root.left;
                while (prev.right != null) prev = prev.right;

                prev.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
