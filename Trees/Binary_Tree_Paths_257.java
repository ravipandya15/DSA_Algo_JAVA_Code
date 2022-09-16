
package Trees;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths_257 {
public class TreeNode {
        
        TreeNode left;
        int val;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
        }
    }

    public static void solve(TreeNode root, StringBuilder str, List<String> list)
    {
        if (root == null) return;

        int len = str.length();
        str.append(root.val);

        if (root.left == null && root.right == null)
        {
            list.add(str.toString());
        }
        else
        {
            str.append("->");
            solve(root.left, str, list);
            solve(root.right, str, list);
        }
        str.setLength(len);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        solve(root, new StringBuilder(""), list);
        return list;
    }
}
