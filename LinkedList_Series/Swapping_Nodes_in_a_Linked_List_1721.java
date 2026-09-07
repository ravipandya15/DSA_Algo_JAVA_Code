public class Swapping_Nodes_in_a_Linked_List_1721 {
    public ListNode swapNodes(ListNode head, int k) {
        // base cases
        if (head == null || head.next == null) return head;
        ListNode cur = head;

        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        if (k > n/2) {
            k = n - k + 1;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev1 = dummy;
        ListNode next1 = null;
        ListNode prev2 = dummy;
        ListNode next2 = null;
        ListNode first = head;
        ListNode second = head;

        while (k-1 > 0) {
            prev1 = first;
            first = first.next;
            k--;
        }

        ListNode last = first;
        while (last.next != null) {
            prev2 = second;
            second = second.next;
            last = last.next;
        }

        next1 = first.next;
        next2 = second.next;

        prev1.next = second;

        if (next1 == second && first == prev2) {
            second.next = first;
        } else {
            second.next = next1;
            prev2.next = first;
        }

        first.next = next2;

        return dummy.next;
    }
}
