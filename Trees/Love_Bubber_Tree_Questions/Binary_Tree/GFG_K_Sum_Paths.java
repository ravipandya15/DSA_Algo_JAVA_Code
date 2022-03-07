package Trees.Love_Bubber_Tree_Questions.Binary_Tree;

import java.util.ArrayList;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class GFG_K_Sum_Paths {
    
    public static void solve(Node root,int k, int[] count, ArrayList<Integer> list)
    {
        if (root == null) return;

        list.add(root.data);

        solve(root.left, k, count, list);
        solve(root.right, k, count, list);

        int sum = 0;
        int size = list.size();
        for (int i = size - 1; i >= 0; i--)
        {
            sum = sum + list.get(i);
            if (sum == k)
                count[0]++;
        }

        list.remove(list.size() - 1);
    }

    public int sumK(Node root,int k)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int[] count = {0};
        solve(root, k, count, list);
        return count[0];
    }

}
