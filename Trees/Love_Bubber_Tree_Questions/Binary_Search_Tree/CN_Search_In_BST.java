package Trees.Love_Bubber_Tree_Questions.Binary_Search_Tree;

public class CN_Search_In_BST {
    
    class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        this.left = null;
	        this.right = null;
	    }
	}
    
    public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
		BinaryTreeNode<Integer> temp = root;
        while (temp != null)
        {
            if (temp.data == x)
            {
                return true;
            }
            if (x < temp.data)
            {
                temp = temp.left;
            }
            else
            {
                temp = temp.right;
            }
        }

        return false;
	}
}
