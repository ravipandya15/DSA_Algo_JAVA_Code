package Trees.Love_Bubber_Tree_Questions.Binary_Tree;

class Pair
{
    int first;
    int second;
    Pair(int f, int s)
    {
        this.first = f;
        this.second = s;
    }
}

public class GFG_Maximum_sum_of_Non_adjacent_nodes {
    
    public static Pair solve(Node root)
    {
        if (root == null)
        {
            return new Pair(0, 0);
        }

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        Pair ans = new Pair(0, 0);
        // include current node
        ans.first = root.data + left.second + right.second;

        // exclude current Node
        ans.second = Math.max(left.first, left.second) + Math.max(right.first, right.second);

        return ans;
    }

    static int getMaxSum(Node root)
    {
        Pair ans = solve(root);
        return Math.max(ans.first, ans.second);
    }
}
