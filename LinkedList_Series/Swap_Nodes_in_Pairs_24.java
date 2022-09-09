package LinkedList_Series;

class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

public class Swap_Nodes_in_Pairs_24 {

    //TC -> O(N)
    // SC -> O(N)
    public ListNode swapPairs(ListNode head) {
        ListNode next = null;
        ListNode prev = null;
        ListNode cur = head;
        int count = 0;
        while (cur != null && count < 2)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }

        if (next != null)
        {
            head.next = swapPairs(next);
        }

        return prev;
    }

    public ListNode swapPairs_1(ListNode head) {
        if (head == null) return null;
        ListNode next = null;
        ListNode prev = null;
        ListNode cur = head;
        int count = 0;
        while (cur != null && count < 2)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }

        head.next = swapPairs(next);
        return prev;
    }
}
