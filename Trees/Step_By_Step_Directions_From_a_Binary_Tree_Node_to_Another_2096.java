package Trees;

public class Step_By_Step_Directions_From_a_Binary_Tree_Node_to_Another_2096 {
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

    public static TreeNode LCA(TreeNode root, int s, int d)
    {
        if (root == null || root.val == s || root.val == d) return root;

        TreeNode left = LCA(root.left, s, d);
        TreeNode right = LCA(root.right, s, d);
        if (left == null) return right;
        else if (right == null) return left;
        return root;
    }

    public static String findPath(TreeNode lca, int val, StringBuilder path, boolean flag)
    {
        if (lca == null) return null;
        if (lca.val == val) return path.toString();

        int len = path.length();
        if (flag)
        {
            String left = findPath(lca.left, val, path.append("L"), flag);
            path.setLength(len);
            String right = findPath(lca.right, val, path.append("R"), flag);
            if (left == null) return right;
            else return left;
        }
        else
        {
            String left = findPath(lca.left, val, path.append("U"), flag);
            path.setLength(len);
            String right = findPath(lca.right, val, path.append("U"), flag);
            if (left == null) return right;
            else return left;
        }
    }
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // step : 1
        // find LCA
        TreeNode lca = LCA(root, startValue, destValue);

        // step : 2
        // find path from lca to startvalue
        String path1 = findPath(lca, startValue, new StringBuilder(""), false);

        // step : 4
        // find path from lca to endvalue
        String path2 = findPath(lca, destValue, new StringBuilder(""), true);

        // step : 5
        // concate both the path
        return path1 + path2;
    }
}
