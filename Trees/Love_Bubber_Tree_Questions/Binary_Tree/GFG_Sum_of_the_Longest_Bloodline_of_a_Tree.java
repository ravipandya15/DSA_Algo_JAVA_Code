package Trees.Love_Bubber_Tree_Questions.Binary_Tree;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

public class GFG_Sum_of_the_Longest_Bloodline_of_a_Tree {
    
    public static void solve(Node root, int len, int[] maxLen, int sum, int[] maxSum)
    {
        // base case
        if (root == null)
        {
            if (len > maxLen[0])
            {
                maxLen[0] = len;
                maxSum[0] = sum;
            }
            else if (len == maxLen[0])
            {
                maxSum[0] = Math.max(sum, maxSum[0]);
            }
            return;
        }

        sum = sum + root.data;

        solve(root.left, len + 1, maxLen, sum, maxSum);
        solve(root.right, len + 1, maxLen, sum, maxSum);
    }

    public int sumOfLongRootToLeafPath(Node root)
    {
        int len = 0, sum = 0;
        int[] maxLen = {0};
        int[] maxSum = {0};

        solve(root, len, maxLen, sum, maxSum);
        return maxSum[0];
    }
}
