package Trees;

import java.util.ArrayList;

class TreeNode
{
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}

public class CN_LeetCode_Subscribe_Boundary_Traversal {
    
    private static boolean isLeaf(TreeNode node)
    {
        return (node.left == null) && (node.right == null);
    }

    private static void addLeftBoundry(TreeNode node, ArrayList<Integer> res)
    {
        TreeNode cur = node.left;
        while(cur != null)
        {
            if (!isLeaf(cur)) res.add(cur.data);
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }

    private static void addLeaf(TreeNode node, ArrayList<Integer> res)
    {
        if (isLeaf(node)) res.add(node.data);

        if (node.left != null) addLeaf(node.left, res);
        if (node.right != null) addLeaf(node.right, res);
    }

    private static void addRightBoundry(TreeNode node, ArrayList<Integer> res)
    {
        TreeNode cur = node.right;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        while(cur != null)
        {
            if (!isLeaf(cur)) temp.add(cur.data);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }

        for (int i = temp.size() -1; i >= 0; i--)
        {
            res.add(temp.get(i));
        }
    }

    public static ArrayList<Integer> traverseBoundary(TreeNode root){
		// Write your code here.
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        if (!isLeaf(root)) res.add(root.data);

        addLeftBoundry(root, res);
        addLeaf(root, res);
        addRightBoundry(root, res);

        return res;
	}

}
