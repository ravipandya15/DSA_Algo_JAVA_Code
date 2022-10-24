package LinkedList_Series;

public class Partition_List_86 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur = head, prev = null;
        while (cur != null)
        {
            if (cur.val < x)
            {
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;

                ListNode next = cur.next;
                if (prev == null)
                {
                    head = next;
                }
                else
                {
                    prev.next = next;
                }

                cur.next = null;
                cur = next;
            }
            else
            {
                prev = cur;
                cur = cur.next;
            }
        }
        newTail.next = head;
        return newHead.next;
    }
}
