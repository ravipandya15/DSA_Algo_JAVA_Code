package Trees;

public class Construct_String_from_Binary_Tree_606 {

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

    public void solve(TreeNode root, StringBuilder sb)
    {
        if (root == null) return;

        sb.append(root.val);

        if (root.left != null && root.right != null)
        {
            sb.append("(");
            solve(root.left, sb);
            sb.append(")");

            sb.append("(");
            solve(root.right, sb);
            sb.append(")");
        }
        else if (root.left == null && root.right != null)
        {
            sb.append("(");
            sb.append(")");

            sb.append("(");
            solve(root.right, sb);
            sb.append(")");
        }
        else if (root.left != null && root.right == null)
        {
            sb.append("(");
            solve(root.left, sb);
            sb.append(")");
        }
    }
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        solve(root, sb);
        return sb.toString();
    }
}
