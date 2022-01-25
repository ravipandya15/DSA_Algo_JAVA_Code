package LinkedList_Series;

class Node
{
    int data;
    Node next;

    Node(int _d)
    {
        this.data = _d;
        this.next = null;
    }
}

public class Singly_Linked_List {
    static Node head;
    static Node tail;

    public static void main(String[] args) {
        
        Node node1 = new Node(10);
        head = node1;
        tail = node1;

        insertAtHead(12, head);
        print(head);

        insertAtHead(15,  head);
        print(head);

        insertAtTail(20,  tail);
        print(head);

        insertAtPosition(1, 50,  head,  tail);
        print(head);

        insertAtPosition(6, 60,  head,  tail);
        print(head);

        insertAtPosition(3, 100,  head,  tail);
        print(head);

        insertAtPosition(9, 100,  head,  tail);
        print(head);

        insertAtPosition(19, 100,  head,  tail);
        print(head);

        //deleteNode_At_Position(1,  head,  tail);
        //print(head);

        //deleteNode_At_Position(7,  head,  tail);
        //print(head);

        //deleteNode_At_Position(5,  head,  tail);
        //print(head);

        //deleteNode_By_Value(10,  head,  tail);
        //print(head);

        //deleteNode_By_Value(50,  head,  tail);
        //print(head);

        //deleteNode_By_Value(60,  head,  tail);
        //print(head);

        System.out.println("head is " + head.data + " tail is " + tail.data);
    }

    public static void insertAtHead(int data, Node head)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void insertAtPosition(int position, int data,  Node head,  Node tail)
    {
        if (position == 1)
        {
            insertAtHead(data,  head);
            return;
        }

        int count = 1;
        Node temp = head;

        while (count < position - 1)
        {
            if (temp != null)
            {
                temp = temp.next;
                count++;
            }
            else
            {
                return;
            }
        }

        if (temp != null && temp.next == null)
        {
            insertAtTail(data,  tail);
            return;
        }
        else
        {
            if (temp == null) return;
        }
            

        // insert at middle
        Node nodeToInsert = new Node(data);
        nodeToInsert.next = temp.next;
        temp.next = nodeToInsert;
    }

    public static void insertAtTail(int data,  Node tail)
    {
        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
    }

    // Deleting Node by Position
    public static void deleteNode_At_Position(int position, Node head, Node tail)
    {
        if (position == 1)
        {// delete 1st Node
            Node cur = head;
            head = head.next;
            cur.next = null;
        }
        else
        {// deleting middle or last node
            int count = 1;
            Node prev = null, cur = head;
            while (count < position)
            {
                prev = cur;
                cur = cur.next;
                count++;
            }

            prev.next = cur.next;
            if (prev.next == null)
                tail = prev;
        }
    }

    // Delete Node by value
    public static void deleteNode_By_Value(int value, Node head, Node tail)
    {
        int count = 1;
        Node cur = head, prev = null;
        while (cur.data != value)
        {
            prev = cur;
            cur = cur.next;
            count++;
        }

        if (count == 1)
        {// deleting 1st Node
            cur = head;
            head = head.next;
            cur.next = null;
        }
        else
        {
            prev.next = cur.next;
            if (prev.next == null)
                tail = prev;
        }
    }

    public static void print(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
}
