package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class All_Possible_Full_Binary_Trees_894 {

    // function will return all possible Full binary trees for given n
    public static List<TreeNode> solve(int n, Map<Integer, List<TreeNode>> dp)
    {
        List<TreeNode> list = new ArrayList<>();
        // base case
        if (n == 0) return list;
        if (n == 1)
        {
            list.add(new TreeNode(0));
            return list;
        }

        if (dp.containsKey(n)) return dp.get(n);

        for (int l = 0; l < n; l++)
        {
            int r = n-1 - l;
            List<TreeNode> left = solve(l, dp);
            List<TreeNode> right =  solve(r, dp);

            for (TreeNode i : left)
            {
                for (TreeNode j : right)
                {
                    list.add(new TreeNode(0, i, j));
                }
            }
        }

        dp.put(n, list);
        return list;
    }
    
    public List<TreeNode> allPossibleFBT(int n) {
        Map<Integer, List<TreeNode>> dp = new HashMap<>();
        return solve(n, dp);
    }
}
