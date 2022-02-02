package LinkedList_Series;

import java.util.ArrayList;;

class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}

public class GFG_Check_if_Linked_List_is_Palindrome {

    private static boolean checkPalindromw(ArrayList<Integer> arr)
    {
        int n = arr.size();
        int s = 0, e = n-1;
        while (s <= e)
        {
            if (arr.get(s) != arr.get(e))
                return false;

            s++;
            e--;
        }

        return true;
    }
    // 1st solution
    // TC -> O(N)
    // SC -> O(N)
    boolean isPalindrome1(Node head) 
    {
        if (head == null || head.next == null) return true;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Node temp = head;
        while (temp != null)
        {
            list.add(temp.data);
            temp = temp.next;
        }

        // check list is palindromw or not
        return checkPalindromw(list);
    }

    public static Node findMiddle(Node node)
    {
        Node slow = node;
        Node fast = node.next;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node reverse(Node node)
    {
        Node cur = node;
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

    // 2nd solution - > Optimal
    // TC -> O(N)
    // SC -> O(1)
    boolean isPalindrome2(Node head) 
    {
        if (head == null || head.next == null) return true;

        // find middle
        Node middle = findMiddle(head);

        middle.next = reverse(middle.next);

        Node head1 = head;
        Node head2 = middle.next;

        while (head2 != null)
        {
            if (head1.data != head2.data)
            {
                return false;
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        // again reverse remaining part so actual linked List remains as it is.
        middle.next = reverse(middle.next);

        return true;
    }
}
