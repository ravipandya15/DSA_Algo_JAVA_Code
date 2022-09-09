package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_Search_Trees_II_95 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) 
        { 
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> solve(int start, int end)
    {
        List<TreeNode> list = new ArrayList<>();
        if (start > end)
        {
            list.add(null);
        }

        for (int i = start; i <= end; i++)
        {
            List<TreeNode> leftTrees = solve(start, i - 1);
            List<TreeNode> rightTrees = solve(i + 1, end);

            for (TreeNode left : leftTrees)
            {
                for (TreeNode right : rightTrees)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }

    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }
}
