package Trees;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class Left_View_Of_Binary_Tree {
    
    private static void recursion(BinaryTreeNode<Integer> node, int level, List<Integer> res)
    {
        if (node == null) return;

        if (level == res.size()) 
        {
            res.add(node.data);
            System.out.println(node.data);
        }

        recursion(node.left, level + 1, res);
        recursion(node.right, level + 1, res);
    }

    public static void leftView(BinaryTreeNode<Integer> root) {
        List<Integer> res = new ArrayList<Integer>();
        recursion(root, 0, res);
    }

}
