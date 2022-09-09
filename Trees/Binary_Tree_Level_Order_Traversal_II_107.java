package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_II_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if (cur.left != null)
                {
                    q.add(cur.left);
                }
                if (cur.right != null)
                {
                    q.add(cur.right);
                }
            }
            list.add(0, temp);
        }
        return list;
    }
}
