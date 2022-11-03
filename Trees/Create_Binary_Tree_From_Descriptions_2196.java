package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Create_Binary_Tree_From_Descriptions_2196 {
    public class TreeNode {
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
    
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        TreeNode root = null;
        for (int[] data : descriptions)
        {
            TreeNode node = map.getOrDefault(data[0], new TreeNode(data[0]));
            TreeNode child = map.getOrDefault(data[1], new TreeNode(data[1]));

            if (data[2] == 1) node.left = child;
            else node.right = child;

            map.put(data[0], node);
            map.put(data[1], child);

            children.add(data[1]);
        }

        for (int[] data : descriptions)
        {
            if (!children.contains(data[0]))
            {
                root = map.get(data[0]);
                break;
            }
        }
        return root;
    }
}

