package Trees.Love_Bubber_Tree_Questions.Binary_Tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class Node
{
    int data;
    Node left;
    Node right;

    Node(int d)
    {
        this.data = d;
        left = null;
        right = null;
    }
}

class Tuple
{
    Node node;
    int row;
    int col;
    public Tuple(Node _node, int _row, int _col)
    {
        node = _node;
        row = _row;
        col = _col;
    }
}

public class GFG_Vertical_Traversal_of_Binary_Tree {
    
    static ArrayList <Integer> verticalOrder(Node root)
    {
        ArrayList<Integer> res = new ArrayList<>();

        TreeMap<Integer, TreeMap<Integer, Queue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<Tuple>();
        queue.add(new Tuple(root, 0, 0));

        while(!queue.isEmpty())
        {
            Tuple tuple = queue.peek();
            queue.poll();

            Node node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if (!map.containsKey(x))
            {
                map.put(x, new TreeMap<>());
            }

            if (!map.get(x).containsKey(y))
            {
                map.get(x).put(y, new LinkedList<>());
            }

            map.get(x).get(y).add(node.data);

            if (node.left != null)
            {
                queue.add(new Tuple(node.left, x-1, y+1));
            }
            if (node.right != null)
            {
                queue.add(new Tuple(node.right, x+1, y+1));
            }
        }

        for (TreeMap<Integer, Queue<Integer>> vertical : map.values())
        {
            for (Queue<Integer> level : vertical.values())
            {
                while (!level.isEmpty())
                {
                    res.add(level.peek());
                    level.poll();
                }
            }
        }
        return res;
    }

}
