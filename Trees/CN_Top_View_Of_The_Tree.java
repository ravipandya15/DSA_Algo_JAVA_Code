package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Pair
{
    BinaryTreeNode node;
    int line;

    Pair(BinaryTreeNode _node, int _line)
    {
        node = _node;
        line = _line;
    }
}

public class CN_Top_View_Of_The_Tree {
    
    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// Write your code here.
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty())
        {
            Pair pair = queue.peek();
            queue.poll();

            BinaryTreeNode node = pair.node;
            int line = pair.line;

            if (map.get(line) == null) map.put(line, node.val);

            if (node.left != null)
            {
                queue.add(new Pair(node.left, line -1));
            }
            if (node.right != null)
            {
                queue.add(new Pair(node.right, line + 1));
            }
        }

        for (int value: map.values())
        {
            res.add(value);
        }

        return res;
	}
    
}
