package Trees.Binary_Search_Tree;

import org.w3c.dom.NodeList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
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

public class Convert_Sorted_List_to_Binary_Search_Tree_109 {

    private static ListNode findMid(ListNode node)
    {
        ListNode slow = node;
        ListNode fast = node;
        ListNode prev = null;

        while (fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        return slow;
    }

    // TC -> O(nlogn) -> LogN -> to find middle
    // SC -> O(logn) > recursive stack space -> check once
    // better approach below
    public TreeNode sortedListToBST_1(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;

        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST_1(head);
        root.right = sortedListToBST_1(midNext);

        return root;
    }


    private ListNode node;
    private TreeNode recursion(int start, int end)
    {
        if (start > end) return null;

        int mid = start + (end - start)/2;

        TreeNode left = recursion(start, mid - 1);

        TreeNode root = new TreeNode(node.val);
        root.left = left;
        node = node.next;

        TreeNode right = recursion(mid + 1, end);
        root.right = right;

        return root;
    }

    // TC -> O(N)
    // SC -> O(logn) > recursive stack space -> check once
    public TreeNode sortedListToBST_2(ListNode head) {

        if (head == null) return null;

        // find count of LinkedList
        int count = 0;
        ListNode temp = head;
        node = head; // node is declared above
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }

        return recursion(0, count - 1);

    }
}
