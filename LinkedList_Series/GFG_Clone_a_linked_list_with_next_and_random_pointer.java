package LinkedList_Series;

import java.util.ArrayList;
import java.util.HashMap;

class Node {
    int data;
    Node next, arb;

    Node(int d) 
    { 
        data = d;
        next = arb = null; 
        
    }
}

public class GFG_Clone_a_linked_list_with_next_and_random_pointer {
    static ArrayList<Node> insertAtTail(Node head, Node tail, int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }

        ArrayList<Node> list = new ArrayList<Node>();
        list.add(head);
        list.add(tail);

        return list;
    }

    // TC -> O(N)
    // SC -> O(N)
    Node copyList1(Node head) {
        Node cloneHead = null;
        Node cloneTail = null;
        Node temp = head;
        ArrayList<Node> list = new ArrayList<Node>();

        while (temp != null)
        {
            list = insertAtTail(cloneHead, cloneTail, temp.data);
            cloneHead = list.get(0);
            cloneTail = list.get(1);
            temp = temp.next;
        }

        // use of HashMap
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        temp = head;
        Node temp2 = cloneHead;
        while (temp != null)
        {
            map.put(temp, temp2);
            temp = temp.next;
            temp2 = temp2.next;
        }

        temp = head;
        temp2 = cloneHead;
        while (temp != null)
        {
            temp2.arb = map.get(temp.arb);
            temp = temp.next;
            temp2 = temp2.next;
        }

        return cloneHead;
    }

    // TC -> O(N)
    // SC -> O(1)
    Node copyList2(Node head) {
        // step 1 -> clone original list (with help of next pointer)
        Node cloneHead = null;
        Node cloneTail = null;
        Node temp = head;
        ArrayList<Node> list = new ArrayList<Node>();

        while (temp != null)
        {
            list = insertAtTail(cloneHead, cloneTail, temp.data);
            cloneHead = list.get(0);
            cloneTail = list.get(1);
            temp = temp.next;
        }

        Node originalNode = head;
        Node cloneNode = cloneHead;
        // step 2 -> cloneNodes add inbetween original linkedList
        while (originalNode != null && cloneNode != null)
        {
            // next is commonly used for both originalNode and cloneNode
            Node next = originalNode.next;
            originalNode.next = cloneNode;
            originalNode = next;

            next = cloneNode.next;
            cloneNode.next = originalNode;
            cloneNode = next;
        }

        originalNode = head;
        cloneNode = cloneHead;
        // step 3 -> set Random pointer
        while (originalNode != null)
        {
            if (originalNode.arb != null)
            {
                originalNode.next.arb = originalNode.arb.next;
            }
            originalNode = originalNode.next.next;
        }

        originalNode = head;
        cloneNode = cloneHead;
        // step 4 -> revert changes done in step2
        while (originalNode != null && cloneNode != null)
        {
            originalNode.next = cloneNode.next;
            originalNode = originalNode.next;

            if (originalNode != null)
            {
                cloneNode.next = originalNode.next;
            }
            
            cloneNode = cloneNode.next;
        }

        // step 5 -> return ans
        return cloneHead;
    }
}
