package Trees;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) {
          val = x;
          left=null;
          right=null;
         }
     }

public class Interview_bit_Path_To_Given_Node {
    
    private static boolean getPath(TreeNode node, int B, List<Integer> res)
    {
        if (node == null) return false;

        res.add(node.val);

        if (node.val == B) return true;

        if (getPath(node.left, B, res) || getPath(node.right, B, res)) return true;

        res.remove(res.size() - 1);

        return false;
    }

    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        if (A == null) return res;
        getPath(A, B, res);
        return res;
    }

}
