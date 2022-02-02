package LinkedList_Series;

import java.util.ArrayList;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class GFG_Add_two_numbers_represented_by_linked_lists {
    
    public static Node reverse(Node head)
    {
        Node cur = head;
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

    public static ArrayList<Node> insertAtTail(Node head, Node tail, int data)
    {
        Node temp = new Node(data);
        if (head == null)
        {   
            head = temp;
            tail = temp;
        }
        else
        {
            tail.next = temp;
            tail = temp;
        }

        ArrayList<Node> list = new ArrayList<Node>();
        list.add(head);
        list.add(tail);
        return list;
    }

    public static Node add(Node first, Node second)
    {
        int carry = 0;
        Node ansHead = null;
        Node ansTail = null;

        while (first != null || second != null || carry != 0)
        {
            int sum = 0;
            if (first != null)
                sum += first.data;
            
            if (second != null)
                sum += second.data;

            sum += carry;

            int digit = sum % 10;
            ArrayList<Node> list = insertAtTail(ansHead, ansTail, digit);
            ansHead = list.get(0);
            ansTail = list.get(1);

            carry = sum / 10;

            if (first != null)
                first = first.next;
            
            if (second != null)
                second = second.next;
        }

        return ansHead;
    }

    static Node addTwoLists(Node first, Node second){
        // step 1: reverse both linked List
        Node newFirst = reverse(first);
        Node newSecond = reverse(second);

        // add numbers from both linkedList
        Node result = add(newFirst, newSecond);

        // reverse resultant Linked List
        Node newResult = reverse(result);

        // reverse first and second linkedList again
        Node oldFirst = reverse(newFirst);
        Node oldSecond = reverse(newSecond);

        return newResult;
    }
}
