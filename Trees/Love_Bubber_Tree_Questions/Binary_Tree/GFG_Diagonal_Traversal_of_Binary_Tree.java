package Trees.Love_Bubber_Tree_Questions.Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Pair
{
    Node node;
    int line;

    Pair(Node _node, int _line)
    {
        node = _node;
        line = _line;
    }
}

public class GFG_Diagonal_Traversal_of_Binary_Tree {
    
    public ArrayList<Integer> diagonal(Node root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Pair> stack = new Stack<Pair>();
        TreeMap<Integer, Queue<Integer>> map = new TreeMap<>();

        stack.push(new Pair(root, 0));

        while (!stack.isEmpty())
        {
            Pair pair = stack.peek();
            stack.pop();

            Node node = pair.node;
            int line = pair.line;

            if (!map.containsKey(line))
            {
                map.put(line, new LinkedList<Integer>());
            }

            map.get(line).add(node.data);

            if (node.right != null)
            {
                stack.push(new Pair(node.right, line));
            }
            if (node.left != null)
            {
                stack.push(new Pair(node.left, line +1));
            }
        }

        for (Queue<Integer> value: map.values())
        {
            for (int val : value)
            {
                res.add(val);
            }
        }

        return res;
    }

}
