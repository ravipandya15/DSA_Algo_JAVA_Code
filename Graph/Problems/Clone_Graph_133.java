package Graph.Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Clone_Graph_133 {

    public Node dfs(Node cur, HashMap<Node, Node> map)
    {
        ArrayList<Node> clone_neighbors = new ArrayList<>();
        Node clone = new Node(cur.val);
        map.put(cur, clone);

        for (Node neighbor : cur.neighbors)
        {
            if (map.containsKey(neighbor))
            {
                clone_neighbors.add(map.get(neighbor));
            }
            else
            {
                Node node = dfs(neighbor, map);
                clone_neighbors.add(node);
            }
        }

        clone.neighbors = clone_neighbors;
        return clone;
    }

    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        if (node == null) return node;
        if (node.neighbors.size() == 0)
        {
            Node clone = new Node(node.val);
            return clone;
        }
        return dfs(node, map);
    }
}
