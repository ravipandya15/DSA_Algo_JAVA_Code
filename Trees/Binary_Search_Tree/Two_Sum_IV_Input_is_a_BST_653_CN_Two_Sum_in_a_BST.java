package Trees.Binary_Search_Tree;

import java.util.ArrayList;
import java.util.Stack;

public class Two_Sum_IV_Input_is_a_BST_653_CN_Two_Sum_in_a_BST {
    
    class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

    private static void InOrderTraversal(BinaryTreeNode<Integer> root, ArrayList<Integer> inOrder)
    {
        if (root == null)
        {
            return;
        }

        InOrderTraversal(root.left, inOrder);
        inOrder.add(root.data);
        InOrderTraversal(root.right, inOrder);
    }

    // 1st approach
    // TC -> O(N)
    // SC -> O(N)
    public static boolean twoSumInBST(BinaryTreeNode<Integer> root, int target) {
        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        InOrderTraversal(root, inOrder);

        int i = 0;
        int j = inOrder.size() - 1;

        // two pointer approach
        while (i < j)
        {
            int sum = inOrder.get(i) + inOrder.get(j);
            if (sum == target)
            {
                return true;
            }
            if (sum > target)
            {
                j--; 
            }
            else
            {
                i++;
            }
        }

        return false;
	}

    public class BinaryIterator
    {
        private Stack<BinaryTreeNode<Integer>> stack = new Stack<BinaryTreeNode<Integer>>();
        private boolean reverse = true;

        public BinaryIterator(BinaryTreeNode<Integer> root, boolean isReverse)
        {
            reverse = isReverse;
            pushAll(root);
        }

        public int Next()
        {
            BinaryTreeNode<Integer> node = stack.peek();
            stack.pop();

            if (reverse)
            {
                pushAll(node.left);
            }
            else
            {
                pushAll(node.right);
            }

            return node.data;
        }

        public boolean hasNext()
        {
            return stack.size() > 0;
        }

        private void pushAll(BinaryTreeNode<Integer> root)
        {
            while (root != null)
            {
                stack.push(root);
                if (reverse)
                {
                    root = root.right;
                }
                else
                {
                    root = root.left;
                }
            }
        }
    }

    // 2nd approach
    // already there in BSTIterator.java file
    // TC -> O(N)
    // SC -> O(H)
    public static boolean twoSumInBST_2(BinaryTreeNode<Integer> root, int target) {
        //correct code
        if (root == null) return false;

        BinaryIterator l = new BinaryIterator(root, false);
        BinaryIterator r = new BinaryIterator(root, true);

        int i = l.Next();
        int j = r.Next();

        while (i < j)
        {
            if ((i + j) == target)
            {
                return true;
            }
            if ((i + j) > target)
            {
                j = r.Next();
            }
            else
            {
                i = l.Next();
            }
        }

         return false;
    }
}
