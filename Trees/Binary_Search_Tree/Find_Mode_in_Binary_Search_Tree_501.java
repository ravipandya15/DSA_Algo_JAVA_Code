package Trees.Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

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

public class Find_Mode_in_Binary_Search_Tree_501 {
    TreeNode prev = null;
    int count = 1, max = Integer.MIN_VALUE;
    public void inorder(TreeNode cur, List<Integer> ans)
    {
        // base case
        if (cur == null) return;
        inorder(cur.left, ans);

        // logic
        if (prev != null)
        {
            if (cur.val == prev.val) count++;
            else count = 1;
        }
        if (count > max)
        {
            max = count;
            ans.clear();
            ans.add(cur.val);
        }
        else if (count == max)
        {
            ans.add(cur.val);
        }
        prev = cur;

        inorder(cur.right, ans);
    }

    public int[] findMode(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);

        int n = ans.size();
        int[] result = new int[n];

        for (int i = 0; i < n; i++)
        {
            result[i] = ans.get(i);
        }
        return result;
    }
}
