package Trees.Love_Bubber_Tree_Questions.Binary_Search_Tree;

import java.util.ArrayList;

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
    }
}

public class CN_Merge_Two_BSTs {
    
    private static void convertBSTTOInorder(TreeNode<Integer> root, ArrayList<Integer> list)
    {
        if (root == null)   return;

        convertBSTTOInorder(root.left, list);
        list.add(root.data);
        convertBSTTOInorder(root.right, list);
    }

    private static ArrayList<Integer> mergeTwosortedLinkedList(ArrayList<Integer> list1, ArrayList<Integer> list2)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int n = list1.size();
        int m = list2.size();
        int i = 0, j = 0;

        while (i < n && j < m)
        {
            if (list1.get(i) < list2.get(j))
            {
                ans.add(list1.get(i));
                i++;
            }
            else
            {
                ans.add(list2.get(j));
                j++;
            }
        }

        while (i < n)
        {
            ans.add(list1.get(i));
            i++;
        }

        while (j < n)
        {
            ans.add(list2.get(j));
            j++;
        }

        return ans;
    }

    private static TreeNode<Integer> inorderToBST(int s, int e, ArrayList<Integer> inOrder)
    {
        if (s > e)
        {
            return null;
        }

        int mid = (s+e)/2;
        TreeNode<Integer> root = new TreeNode<Integer>(inOrder.get(mid));
        root.left = inorderToBST(s, mid-1, inOrder);
        root.right = inorderToBST(mid+1, e, inOrder);

        return root;
    }

    public static TreeNode <Integer> mergeBST(TreeNode<Integer> root1, TreeNode<Integer> root2) 
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        // step 1
        convertBSTTOInorder(root1, list1);
        convertBSTTOInorder(root2, list2);

        // step 2
        // merge two sorted linkedList
        ArrayList<Integer> ans = mergeTwosortedLinkedList(list1, list2);

        // step 3
        // inorder to Balanced BST
        return inorderToBST(0, ans.size() - 1, ans);
    }
}
