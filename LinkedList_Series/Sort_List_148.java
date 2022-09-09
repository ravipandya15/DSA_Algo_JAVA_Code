package LinkedList_Series;

class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Sort_List_148 {
    private static ListNode findMid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode mergeSortedList(ListNode left, ListNode right)
    {
        if (left == null) return right;
        if (right == null) return left;

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        while (left != null && right != null)
        {
            if (left.val < right.val)
            {
                temp.next = left;
                temp = left; // or temp = temp.next
                left = left.next;
            }
            else
            {
                temp.next = right;
                temp = right; 
                right = right.next;
            }
        }

        if (left != null)
        {
            temp.next = left;
        }
        else if (right != null)
        {
            temp.next = right;
        }

        return ans.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // find mid;
        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        // recursively sort left and right part
        left = sortList(left);
        right = sortList(right);

        // merge sorted List
        ListNode result = mergeSortedList(left, right);

        return result;
    }
}
