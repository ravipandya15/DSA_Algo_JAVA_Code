package Trees;

class BinaryTreeNode<Integer> {
    int data;
    BinaryTreeNode < Integer > left;
    BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}

public class CN_Children_Sum_Property {
    
    public static void changeTree(BinaryTreeNode <Integer> root) {
        if (root == null) return;
        int child = 0;
        if (root.left != null) child += root.left.data;
        if (root.right != null) child += root.right.data;
        if (child >= root.data) root.data = child;
        else
        {
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;
        if (root.left != null) total += root.left.data;
        if (root.right != null) total += root.right.data;
        // below if condition is required. if both left ad right is null then total remains 0 and root.data becomes 0.
        if (root.left != null || root.right != null) root.data = total;

        // below condition will also work instead of line no 34 condition
        // if (total > root.data) root.data = total;
    }

}
