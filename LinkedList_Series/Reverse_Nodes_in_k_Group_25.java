package LinkedList_Series;

class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


// taken referrence from
// 24. Swap Nodes in Pairs

public class Reverse_Nodes_in_k_Group_25 {
    public static ListNode solve(ListNode head, int k, int size)
    {
        ListNode next = null;
        ListNode prev = null;
        ListNode cur = head;
        int count = 0;
        if (size < k) return head;
        while (cur != null && count < k)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }

        if (next != null)
        {
            head.next = solve(next, k, size - k);
        }

        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null)
        {
            cur = cur.next;
            count++;
        }
        
        return solve(head, k, count);
    }
}
