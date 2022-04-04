package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    
    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class CN_Time_To_Burn_Tree {
    
    private static BinaryTreeNode<Integer> bfsToParents(BinaryTreeNode<Integer> root, int start, 
                                    HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parent_list)
    {
        BinaryTreeNode<Integer> target = new BinaryTreeNode<>(-1);
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty())
        {
            BinaryTreeNode<Integer> node = q.peek();
            q.poll(); 
            if (node.data == start) target = node;

            if (node.left != null) 
            {
                parent_list.put(node.left, node);
                q.add(node.left);
            }
            if (node.right != null)
            {
                parent_list.put(node.right, node);
                q.add(node.right);
            }
        }
        return target;
    }

    private static int timeToBurn(BinaryTreeNode<Integer> target, HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parent_list)
    {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(target);
        HashMap<BinaryTreeNode<Integer>, Boolean> visited = new HashMap<>();
        visited.put(target, true);
        int maxi = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            int flag = 0;
            
            for (int i = 0; i < size; i++)
            {
                BinaryTreeNode<Integer> node = q.peek();
                q.poll();

                if (node.left != null && visited.get(node.left) == null)
                {
                    flag = 1;
                    q.add(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && visited.get(node.right) == null)
                {
                    flag = 1;
                    q.add(node.right);
                    visited.put(node.right, true);
                } 
                if (parent_list.get(node) != null && visited.get(parent_list.get(node)) == null)
                {
                    flag = 1;
                    q.add(parent_list.get(node));
                    visited.put(parent_list.get(node), true);
                }
            }
            if (flag == 1) maxi++;
        }
        return maxi;
    }

    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parent_list = new HashMap<>();
        BinaryTreeNode<Integer> target = bfsToParents(root, start, parent_list);
        int maxi = timeToBurn(target, parent_list);
        return maxi;
    }

}
