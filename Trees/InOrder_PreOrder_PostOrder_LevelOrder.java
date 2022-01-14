package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val)
    {
        this.val = val;
    }
}

public class InOrder_PreOrder_PostOrder_LevelOrder {
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        var result1 = inorderTraversal(root);
        var result2 = preorderTraversal(root);
        var result3 = postorderTraversal(root);
    }

    public static void DfsInorder(TreeNode root, List<Integer> result)
    {
        if (root == null) return;

        DfsInorder(root.left, result);
        result.add(root.val);
        DfsInorder(root.right, result);
    }
    
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        DfsInorder(root, result);
        return result;
    }

    public static void DfsPreorder(TreeNode root, List<Integer> result)
    {
        if (root == null) return;

        result.add(root.val);
        DfsPreorder(root.left, result);
        DfsPreorder(root.right, result);
    }
    
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        DfsPreorder(root, result);
        return result;
    }

    public static void DfsPostorder(TreeNode root, List<Integer> result)
    {
        if (root == null) return;

        DfsPostorder(root.left, result);
        DfsPostorder(root.right, result);
        result.add(root.val);
    }
    
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        DfsPostorder(root, result);
        return result;
    }

    //Level Order
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> temp = new LinkedList<Integer>();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = q.peek();
                q.poll();
                if (node.left != null) 
                {
                    q.add(node.left);
                } 
                if (node.right != null)
                {
                    q.add(node.right);
                }
                temp.add(node.val);
            }
            result.add(temp);
        } 
        return result;
    }
}


