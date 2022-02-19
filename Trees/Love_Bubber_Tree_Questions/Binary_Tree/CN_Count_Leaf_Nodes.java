package Trees.Love_Bubber_Tree_Questions.Binary_Tree;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    
    public BinaryTreeNode(T data) {
      this.data = data;
    }
  }

public class CN_Count_Leaf_Nodes {
    
    public static void solve(BinaryTreeNode<Integer> root, int[] count)
    {
        if (root == null) return;

        if (root.left == null && root.right == null)
        {
            count[0]++;
            return;
        }

        solve(root.left, count);
        solve(root.right, count);
    }

    public static int noOfLeafNodes(BinaryTreeNode<Integer> root) {
        int[] count = {0};
        solve(root, count);
        return count[0];
    }

}
