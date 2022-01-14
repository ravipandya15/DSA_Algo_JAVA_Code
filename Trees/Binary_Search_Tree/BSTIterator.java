package Trees.Binary_Search_Tree;

import java.util.Stack;

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

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    boolean reverse = true;
    public BSTIterator(TreeNode root, boolean isReverse) {
        // this flag must be set to isReverse before PushAll() function ->
        // otherwise PushAll function will perform for reverse = true
        reverse = isReverse;
        pushAll(root);
    }
    
    public int next() {
        TreeNode node = stack.peek();
        stack.pop();
        if (reverse) pushAll(node.left);
        else pushAll(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node)
    {
        while (node != null)
        {
           stack.push(node);
           if (reverse) node = node.right;
            else node = node.left;
        }
    }
}

class Solution {
    
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();  // this is r.before() find of thing
        while (i < j)
        {
            if ((i + j) == k) return true;
            else if ((i + j) < k) i = l.next();
            else j = r.next();
        }
        return false;
    }

}
