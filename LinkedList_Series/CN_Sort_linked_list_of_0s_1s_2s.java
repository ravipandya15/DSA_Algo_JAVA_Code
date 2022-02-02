package LinkedList_Series;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

public class CN_Sort_linked_list_of_0s_1s_2s {
    
    public static Node<Integer> sortList1(Node<Integer> head) {
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        Node<Integer> temp = head;

        while (temp != null)
        {
            if (temp.data == 0)
                zeroCount++;
            else if(temp.data == 1)
                oneCount++;
            else if(temp.data == 2)
                twoCount++;

            temp = temp.next;
        }

        temp = head;
        while (temp != null)
        {
            if (zeroCount != 0)
            {
                temp.data = 0;
                zeroCount--;
            }
            else if (oneCount != 0)
            {
                temp.data = 1;
                oneCount--;
            }
            else if (twoCount != 0)
            {
                temp.data = 2;
                twoCount--;
            }

            temp = temp.next;
        }

        return head;
	}

    public static Node<Integer> insertAtTail(Node<Integer> tail, Node<Integer> node)
    {
        tail.next = node;
        tail = node;
        return tail;
    }

    // if Data replacement is not allowed.
    public static Node<Integer> sortList2(Node<Integer> head) {
        Node<Integer> zeroHead = new Node<Integer>(-1);
        Node<Integer> zeroTail = zeroHead;
        Node<Integer> oneHead = new Node<Integer>(-1);
        Node<Integer> oneTail = oneHead;
        Node<Integer> twoHead = new Node<Integer>(-1);
        Node<Integer> twoTail = twoHead;

        Node<Integer> cur = head;
        while (cur != null)
        {
            int data = cur.data;
            if (data == 0)
                zeroTail = insertAtTail(zeroTail, cur);
            else if (data == 1)
                oneTail = insertAtTail(oneTail, cur);
            else if (data == 2)
                twoTail = insertAtTail(twoTail, cur);

            cur = cur.next;
        }

        if (oneHead.next != null)
        {
            zeroTail.next = oneHead.next;
        }
        else
        {
            zeroTail.next = twoHead.next;
        }

        oneTail.next = twoHead.next;
        twoTail.next = null;

        head = zeroHead.next;
        return head;
	}
}
