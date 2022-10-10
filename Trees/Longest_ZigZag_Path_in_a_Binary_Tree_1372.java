package Trees;

import javafx.util.Pair;

public class Longest_ZigZag_Path_in_a_Binary_Tree_1372 {
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


    public class Node
    {
        int left;
        int right;

        public Node() {
            this.left = 0;
            this.right = 0;
        }

        public Node(int left, int right)
        {
            this.left = left;
            this.right = right;
        }
    }

    public Node solve(TreeNode root, int[] maxi)
    {
        if (root == null) return new Node();

        Node leftNode = solve(root.left, maxi);
        Node rightNode = solve(root.right, maxi);

        Node node = new Node();
        node.left = leftNode.right + 1;
        node.right = rightNode.left + 1;

        maxi[0] = Math.max(maxi[0], Math.max(node.left, node.right));
        return node;
    }
    
    public int longestZigZag(TreeNode root) {
        int[] maxi = {0};
        Node node = solve(root, maxi);
        return maxi[0] - 1;
    }

    public Pair<Integer, Integer> solve_1(TreeNode root, int[] maxi)
    {
        if (root == null) return new Pair<Integer, Integer>(0, 0);

        Pair<Integer, Integer> leftNode = solve_1(root.left, maxi);
        Pair<Integer, Integer> rightNode = solve_1(root.right, maxi);

        Pair<Integer, Integer> node = new Pair<Integer, Integer>(leftNode.getValue() + 1, rightNode.getKey() + 1);

        maxi[0] = Math.max(maxi[0], Math.max(node.getKey(), node.getValue()));
        return node;
    }

    public int longestZigZag_1(TreeNode root) {
        int[] maxi = {0};
        Pair<Integer, Integer> node = solve_1(root, maxi);
        return maxi[0] - 1;
    }
}
