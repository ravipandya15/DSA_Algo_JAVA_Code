package LinkedList_Series;

class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    };

public class CN_Fold_and_Merge_Linked_List {
    
    public static Node reverse(Node head2)
    {
        if (head2 == null) return head2;

        Node cur = head2;
        Node prev = null;
        Node next = null;
        while (cur != null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
	public static Node foldAndMerge(Node head) {
		
        if (head.data == -1) return head;

            Node temp = head;
            Node temp2 = null;
            while (temp.data != -1)
            {
                temp2 = temp;
                temp = temp.next;
            }

            temp2.next = null;

            Node slow = head;
            Node fast = head.next;

            while (fast != null && fast.next != null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }

            Node head2 = slow.next;
            slow.next = null;

            head = reverse(head);

            Node cur = head2;
            Node prev = null;

            while (cur != null)
            {
                cur.data = cur.data * head.data;
                prev = cur;
                cur = cur.next;
                head = head.next;
            }

            prev.next = new Node(-1);

            return head2;
	}

}
