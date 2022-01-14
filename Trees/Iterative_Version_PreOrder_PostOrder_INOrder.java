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

public class Iterative_Version_PreOrder_PostOrder_INOrder {
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
        var result3 = postorderTraversal_1(root);
        var result4 = postorderTraversal_2(root);
    }

    // TC -> O(N)
    // SC -> O(N)
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty())
        {
            TreeNode node = stack.peek();
            stack.pop();
            result.add(node.val);

            if (node.right != null)
            {
                stack.push(node.right);
            }
            if (node.left != null)
            {
                stack.push(node.left);
            }
        }
        return result;
    }

    // TC -> O(N)
    // SC -> O(N) 
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        while(true)
        {
            if (node != null)
            {
                stack.push(node);
                node = node.left;
            }
            else{
                if (stack.isEmpty()) break;
                node = stack.peek();
                stack.pop();
                inOrder.add(node.val);
                node = node.right;
            }
        }
        return inOrder;
    }


    //using 2 Stack
    public static List<Integer> postorderTraversal_1(TreeNode root) {
        List<Integer> postOrder = new ArrayList<Integer>();
        if (root == null) return postOrder;
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();
        st1.push(root);

        while(!st1.empty())
        {
            root = st1.peek();
            st1.pop();
            st2.push(root);

            if (root.left != null) st1.push(root.left);
            if (root.right != null) st1.push(root.right);
        }

        while (!st2.empty())
        {
            postOrder.add(st2.peek().val);
            st2.pop();
        }

        return postOrder;
    }

    // TLE mare chhe -> Check SDE Cheet or Free ka Tree Series Code
    //using 1 Stack
    public static List<Integer> postorderTraversal_2(TreeNode root) {
        //iterative approach
        List<Integer> postOrder = new ArrayList<Integer>();
        if (root == null) return postOrder;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while ( cur != null || !stack.isEmpty())
        {
            if (cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }
            else
            {
                TreeNode temp = stack.peek().right;
                if (temp == null)
                {
                    temp = stack.peek();
                    stack.pop();
                    postOrder.add(temp.val);
                    if (!stack.isEmpty() && temp == stack.peek().right)
                    {
                        temp = stack.peek();
                        stack.pop();
                        postOrder.add(temp.val);
                    }
                }
                else
                {
                    cur = temp;
                }
            }
        }
        return postOrder;
    }
}


