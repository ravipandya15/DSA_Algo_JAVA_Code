package Trees.Love_Bubber_Tree_Questions.Binary_Tree;

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class GFG_Sum_Tree {
    
    public static int solve(Node root)
    {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.data;
        
        int left = solve(root.left);
        if (left == -1) return -1;
        int right = solve(root.right);
        if (right == -1) return -1;
        
        if (root.data != (left + right)) return -1;
        
        return root.data + left + right;
    }
    
	boolean isSumTree(Node root)
	{
        return solve(root) != -1;
	}
}
