package Trees.Love_Bubber_Tree_Questions.Binary_Tree;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

public class GFG_Kth_Ancestor_in_a_Tree {
    
    public static Node solve(Node root, int[] count, int node)
    {
        // base case
        if (root == null) return null;

        if (root.data == node)
        {
            return root;
        }

        Node left = solve(root.left, count, node);
        Node right = solve(root.right, count, node);

        if (left != null && right == null)
        {
            count[0]--;
            if (count[0] <= 0)
            {
                // to lock the answer -> edge case
                count[0] = Integer.MAX_VALUE;
                return root;
            }
            return left;
        }

        if (left == null && right != null)
        {
            count[0]--;
            if (count[0] <= 0)
            {
                // to lock the answer -> edge case
                count[0] = Integer.MAX_VALUE;
                return root;
            }
            return right;
        }
        else
        {
            // both null .   -> both non - null case never comes
            return null;
        }
    }

    public int kthAncestor(Node root, int k, int node)
    {
        int[] count = {k};
        Node ans = solve(root, count, node);
        if (ans == null || ans.data == node)  //ans.data == node -> edge case means count[0] > 0
        {
            return -1;
        }
        return ans.data;
    }
}
