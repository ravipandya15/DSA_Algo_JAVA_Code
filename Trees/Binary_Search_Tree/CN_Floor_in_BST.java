package Trees.Binary_Search_Tree;

class TreeNode<T>
{
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data)
    {
        this.data = data;
        left = null;
        right = null;
    }
};

public class CN_Floor_in_BST {
    
    public static int floorInBST(TreeNode<Integer> root, int X) {
        int floor = -1;
        while (root != null)
        {
            if (root.data == X)
            {
                floor = root.data;
                return floor;
            }
            if (X < root.data)
            { // left side
                root = root.left;
            }
            else
            {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}
