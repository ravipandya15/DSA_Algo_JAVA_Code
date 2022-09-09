package LinkedList_Series;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Remove_Duplicates_from_Sorted_List_83_CN_Remove_Duplicates_From_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode cur = head;
        while (cur != null)
        {
            if (cur.next != null && cur.val == cur.next.val)
            {
                ListNode next_next = cur.next.next;
                ListNode nodeToDetete = cur.next;
                cur.next = next_next;
                nodeToDetete.next = null;
            }
            else
            {
                cur = cur.next;
            }
        }

        return head;
    }
}
