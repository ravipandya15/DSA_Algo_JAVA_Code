package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

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

class Tuple
{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode _node, int _row, int _col)
    {
        node = _node;
        row = _row;
        col = _col;
    }
}

public class Vertical_Order_Traversal_of_a_Binary_Tree_987 {
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<Tuple>();
        queue.add(new Tuple(root, 0, 0));

        while(!queue.isEmpty())
        {
            Tuple tuple = queue.peek();
            queue.poll();

            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if (!map.containsKey(x))
            {
                map.put(x, new TreeMap<>());
            }

            if (!map.get(x).containsKey(y))
            {
                map.get(x).put(y, new PriorityQueue<>());
            }

            map.get(x).get(y).add(node.val);

            if (node.left != null)
            {
                queue.add(new Tuple(node.left, x-1, y+1));
            }
            if (node.right != null)
            {
                queue.add(new Tuple(node.right, x+1, y+1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> vertical : map.values())
        {
            res.add(new ArrayList<Integer>());
            for (PriorityQueue<Integer> level : vertical.values())
            {
                while (!level.isEmpty())
                {
                    res.get(res.size() - 1).add(level.peek());
                    level.poll();
                }
            }
        }
        return res;
    }
    
}
