package Trees.N_Array_Tree;

import java.util.ArrayList;
import java.util.List;

public class N_ary_Tree_Preorder_Traversal_589 {
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void solve(Node root, List<Integer> list)
    {
        if (root == null) return;

        list.add(root.val);

        for (Node node : root.children)
        {
            solve(node, list);
        }
    }
    
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        solve(root, list);
        return list;
    }
}
