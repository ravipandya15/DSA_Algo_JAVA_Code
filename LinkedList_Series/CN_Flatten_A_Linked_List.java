package LinkedList_Series;

class Node {
	int data;
	Node next;
	Node child;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.child = null;
	}
}

public class CN_Flatten_A_Linked_List {

    public static void main(String[] args) {
        
    }

    public static Node merge(Node down, Node right)
    {
        Node ans = new Node(-1);
        Node temp = ans;

        while (down != null && right != null)
        {
            if (down.data < right.data)
            {
                temp.next = down;
                temp = temp.next;
                down = down.child;
                temp.child = null;
            }
            else
            {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }

        while (down != null)
        {
            temp.next = down;
            temp = temp.next;
            down = down.child;
            temp.child = null;
        }

        while (right != null)
        {
            temp.next = right;
            temp = temp.next;
            right = right.next;
        }

        return ans.next;
    }

    public static Node flattenLinkedList(Node start) {
        if (start == null) return start;

        Node down = start;

        Node right = flattenLinkedList(down.next);
        down.next = null;

        Node result = merge(down, right);

        return result;
   }
}
