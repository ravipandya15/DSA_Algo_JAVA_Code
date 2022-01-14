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

public class Binary_Search_Tree_Iterator_173 {
    
}

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode node = stack.peek();
        stack.pop();
        pushAll(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node)
    {
        // for (; node != null; stack.Push(node), node = node.left);
        // in while loop
        while (node != null)
        {
           stack.push(node);
           node = node.left;
        }
    }
}
