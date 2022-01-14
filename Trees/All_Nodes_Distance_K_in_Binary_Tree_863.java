package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class All_Nodes_Distance_K_in_Binary_Tree_863 {
    
    private static void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            TreeNode node = q.peek();
            q.poll();
            if (node.left != null)
            {
                parent_track.put(node.left, node);
                q.add(node.left);
            }
            if (node.right != null)
            {
                parent_track.put(node.right, node);
                q.add(node.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track);
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited =new HashMap<>();
        q.add(target);
        visited.put(target, true);
        int dis = 0;
        while (!q.isEmpty())
        {
            int size = q.size();
            if (dis == k) break;
            dis++;
            for (int i = 0; i < size; i++)
            {
                TreeNode node = q.peek();
                q.poll();

                if (node.left != null && visited.get(node.left) == null)
                {
                    q.add(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && visited.get(node.right) == null)
                {
                    q.add(node.right);
                    visited.put(node.right, true);
                }
                // check parent node
                if (parent_track.get(node) != null && visited.get(parent_track.get(node)) == null)
                {
                    q.add(parent_track.get(node));
                    visited.put(parent_track.get(node), true);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty())
        {
            TreeNode node = q.peek();
            q.poll();
            res.add(node.val);
        }
        return res;
    }
    
}
