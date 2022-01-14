package Trees;

import java.util.LinkedList;
import java.util.Queue;

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

class Pair
{
    TreeNode node;
    int index;
    Pair(TreeNode _node, int _index)
    {
        node = _node;
        index = _index;
    }
}
public class Maximum_Width_of_Binary_Tree_662 {

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        q.add(new Pair(root, 0));

        while (!q.isEmpty())
        {
            int size = q.size();
            int min_level_index = q.peek().index;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++)
            {
                Pair pair = q.peek();
                q.poll();
                int cur_index = pair.index - min_level_index;
                TreeNode node = pair.node;

                if (i == 0) first = cur_index;
                if (i == size - 1) last = cur_index;
                if (node.left != null) q.add(new Pair(node.left, cur_index * 2 + 1));
                if (node.right != null) q.add(new Pair(node.right, cur_index * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}
