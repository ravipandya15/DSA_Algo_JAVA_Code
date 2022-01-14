package Trees.Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class Kth_Smallest_Element_in_a_BST_230 {
    
    public int morris_kthSmallest(TreeNode root, int k) {
        //Morris Traversal
        TreeNode cur = root;
        int count = 0;
        while (cur != null)
        {
            if (cur.left == null)
            {
                count++;
                if (count == k) return cur.val;
                cur = cur.right;
            }
            else
            {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur)
                {
                    prev = prev.right;
                }
                if (prev.right == null)
                {
                    prev.right = cur;
                    cur = cur.left;
                }
                else
                {
                    prev.right = null;
                    count++;
                    if (count == k) return cur.val;
                    cur = cur.right;
                }
            }
        }
        return -1;
    }

    private static void inOrder(TreeNode root, int k, int count, List<Integer> ans)
    {
        if (root == null) return;

        inOrder(root.left, k, count, ans);
        ans.add(root.val);
        inOrder(root.right, k, count, ans);
    }

    //Recursion
    public int kthSmallest1(TreeNode root, int k) {
        //Recursion
        List<Integer> ans = new ArrayList<>();
        inOrder(root, k, 0, ans);
        return ans.get(k-1);
    }

    //Iterative
    public int kthSmallest2(TreeNode root, int k) {
        //Iterative
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        TreeNode node = root;
        int count = 0;
        while (true)
        {
            if (node != null)
            {
                st.push(node);
                node = node.left;
            }
            else
            {
                if (st.isEmpty()) break;
                node = st.peek();
                st.pop();

                count++;
                if (count == k) return node.val;

                node = node.right;
            }
        }
        return -1;
    }
}
