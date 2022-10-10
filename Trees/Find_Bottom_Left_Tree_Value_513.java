package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Find_Bottom_Left_Tree_Value_513 {
    public class TreeNode {
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

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 0;

        while (!q.isEmpty())
        {
            int size = q.size();
            ans = q.peek().val;
            for (int i = 0; i < size; i++)
            {
                TreeNode node = q.peek();
                q.poll();

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return ans;
    }
}
