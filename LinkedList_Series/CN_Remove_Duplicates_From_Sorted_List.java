package LinkedList_Series;

public class CN_Remove_Duplicates_From_Sorted_List {
    
    public static Node uniqueSortedList(Node head) {
        if (head == null) return null;

        Node cur = head;
        while (cur != null)
        {
            if (cur.next != null && cur.data == cur.next.data)
            {
                Node next_next = cur.next.next;
                Node nodeToDetete = cur.next;
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
