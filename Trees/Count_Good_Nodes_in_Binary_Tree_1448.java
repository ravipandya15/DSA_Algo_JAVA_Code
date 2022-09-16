package Trees;

public class Count_Good_Nodes_in_Binary_Tree_1448 {
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

    public static long solve(TreeNode root, int maxi)
    {
        if (root == null) return 0;
        long count = 0;
        if (root.val >= maxi)
        {
            count++;
            maxi = root.val;
        }
        count += solve(root.left, maxi);
        count += solve(root.right, maxi);
        return count;
    }

    public int goodNodes(TreeNode root) {
        return (int)solve(root, Integer.MIN_VALUE);
    }
}
