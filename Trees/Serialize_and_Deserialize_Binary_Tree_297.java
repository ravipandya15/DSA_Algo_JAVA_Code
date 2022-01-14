package Trees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Serialize_and_Deserialize_Binary_Tree_297 {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty())
        {
            TreeNode node = q.peek();
            q.poll();
            if (node == null)
            {
                res.append("#,");
                continue;
            }
            res.append(node.val + ",");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        int i = 1;
        while(!q.isEmpty())
        {
            TreeNode node = q.peek();
            q.poll();
            if (!values[i].equals("#"))
            {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                q.add(left);
            }
            i++;
            // i++ will not work. ++i will work or add one line b/w two if and write i++;
            if (!values[i].equals("#"))
            {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                q.add(right);
            }
            i++;
        }
        return root;
    }

}
