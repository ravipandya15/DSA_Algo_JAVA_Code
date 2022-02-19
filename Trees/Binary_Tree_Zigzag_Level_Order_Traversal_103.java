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
    public TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {
    
    public static void main(String[] args)
    {
        System.out.println("103. Binary Tree Zigzag Level Order Traversal");
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> tempList = new ArrayList<Integer>(size);
            for (int i = 0; i < size; i++)
            {
                TreeNode temp = queue.peek();
                queue.poll();

                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);

                if (leftToRight) tempList.add(temp.val);
                else tempList.add(0,temp.val);
            }
            // if (!leftToRight)
            // {
            //    Collections.reverse(tempList);
            // }
            result.add(tempList);
            leftToRight = !leftToRight;
        }
        return result;
    }


    public static ArrayList<Integer> zigzagLevelOrder_GFG(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> tempList = new ArrayList<Integer>(size);
            for (int i = 0; i < size; i++)
            {
                TreeNode temp = queue.peek();
                queue.poll();

                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);

                if (leftToRight) tempList.add(temp.val);
                else tempList.add(0,temp.val);
            }
            // if (!leftToRight)
            // {
            //    Collections.reverse(tempList);
            // }
            result.add(tempList);
            leftToRight = !leftToRight;
        }

        for (var item : result)
        {
            list.addAll(item);
        }

        return list;
    }
}
