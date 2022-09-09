package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Average_of_Levels_in_Binary_Tree_637 {
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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            double size = q.size();
            double sum = 0;
            for (int i = 0; i < size; i++)
            {
                TreeNode cur = q.peek();
                q.poll();
                sum += cur.val;
                if (cur.left != null)
                {
                    q.add(cur.left);
                }
                if (cur.right != null)
                {
                    q.add(cur.right);
                }
            }
            list.add(sum / size);
        }
        return list;
    }
}
