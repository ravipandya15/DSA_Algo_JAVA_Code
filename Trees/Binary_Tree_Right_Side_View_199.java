package Trees;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
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

public class Binary_Tree_Right_Side_View_199 {
 
    private static void Recursion(TreeNode node, int level, List<Integer> res)
    {
        if (node == null) return;

        if (level == res.size()) res.add(node.val);

        Recursion(node.right, level + 1, res);
        Recursion(node.left, level + 1, res);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Recursion(root, 0, res);
        return res;
    }

}
