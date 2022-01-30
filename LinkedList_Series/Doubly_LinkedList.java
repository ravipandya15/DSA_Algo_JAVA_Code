package LinkedList_Series;

class Node
{
    int data;
    Node next;
    Node prev;

    Node(int _d)
    {
        this.data = _d;
        this.next = null;
        this.prev = null;
    }
}

public class Doubly_LinkedList {

    // travser LinkedList
    public static void printLinkedList(Node head)
    {
        Node cur = head;
        while (cur != null)
        {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    // gives Length of LinkedList
    public static int lengthOfLinkedList(Node head)
    {
        int count = 0;
        Node cur = head;
        while (cur != null)
        {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public static void main(String[] args) {
        
        Node node1 = new Node(10);
        Node head = node1;

        printLinkedList(head);
        int length = lengthOfLinkedList(head);
        System.out.println("length of linkedList is " + length);
    }
}
