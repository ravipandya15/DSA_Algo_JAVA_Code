package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Check_Completeness_of_a_Binary_Tree_958 {
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

    public static boolean check(Queue<TreeNode> queue)
    {
        while (!queue.isEmpty())
        {
            TreeNode node = queue.peek();
            queue.poll();
            if (node != null) return false;
        }
        return true;
    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.peek();
                queue.poll();
                if (node == null) return check(queue);
                queue.add(node.left);
                queue.add(node.right);
            }
            
        }
        return queue.isEmpty();
    }
}
