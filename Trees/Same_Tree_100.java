package Trees;

class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Same_Tree_100 {
    public static void main(String[] args)
    {
        System.out.println("100. Same Tree");
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return (p == q);
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
