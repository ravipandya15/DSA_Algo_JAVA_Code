package LinkedList_Series;

class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

public class Remove_Duplicates_from_Sorted_List_II_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode ans = prev;

        while (cur != null)
        {
            if (cur.next != null && cur.val == cur.next.val)
            {
                while (cur.next != null && cur.val == cur.next.val)
                {
                    cur = cur.next;
                }
                ListNode next = cur.next;
                prev.next = next;
                cur.next = null;
                cur = next;
            }
            else
            {
                prev = cur;
                cur = cur.next;
            }
        }
        return ans.next;
    }
}
