package Trees;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 {
    
    private static TreeNode buildTreePostIn(int[] inorder, int inStart, int inEnd, 
                                            int[] postorder, int postStart, int postEnd, 
                                            Map<Integer, Integer> map)
    {
        if (inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTreePostIn(inorder, inStart, inRoot - 1, postorder, postStart, postStart + numsLeft - 1, map);
        root.right = buildTreePostIn(inorder, inRoot + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, map);

        return root;

    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
        {
            map.put(inorder[i], i);
        }

        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

}
