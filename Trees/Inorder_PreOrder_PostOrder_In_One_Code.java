package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

class Pair
{
    public int num;
    public TreeNode node;
    public Pair(TreeNode root, int val)
    {
        node = root;
        num = val;
    }
}

public class Inorder_PreOrder_PostOrder_In_One_Code {
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
    }

    public static void AllTraversal(TreeNode root)
    {
        Stack<Pair> stack = new Stack<Pair>();
        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> in = new ArrayList<Integer>();
        List<Integer> post = new ArrayList<Integer>();

        stack.push(new Pair(root, 1));

        while (!stack.isEmpty())
        {
            Pair it = stack.peek();
            stack.pop();

            if (it.num == 1)
            {
                pre.add(it.node.val);
                it.num++;
                stack.push(it);

                if (it.node.left != null) stack.push(new Pair(it.node.left, 1));
            }
            else if (it.num == 2)
            {
                in.add(it.node.val);
                it.num++;
                stack.push(it);

                if (it.node.right != null) stack.push(new Pair(it.node.right, 1));
            }
            else
            {
                post.add(it.node.val);
            }
        }
    }
}