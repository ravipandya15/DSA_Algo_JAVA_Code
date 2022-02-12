package LinkedList_Series;

class Node<T> {
    T data;
    Node<T> next;
    
    public Node(T data) {
        this.data = data;
    }
}

public class CN_MergeSort_Linked_List {

    private static Node<Integer> findMid(Node<Integer> head)
    {
        Node<Integer> slow = head;
        Node<Integer> fast = head.next;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static Node<Integer> mergeSortedList(Node<Integer> left, Node<Integer> right)
    {
        if (left == null) return right;
        if (right == null) return left;

        Node<Integer> ans = new Node<Integer>(-1);
        Node<Integer> temp = ans;

        while (left != null && right != null)
        {
            if (left.data < right.data)
            {
                temp.next = left;
                temp = left; // or temp = temp.next
                left = left.next;
            }
            else
            {
                temp.next = right;
                temp = right; 
                right = right.next;
            }
        }

        if (left != null)
        {
            temp.next = left;
        }
        else if (right != null)
        {
            temp.next = right;
        }

        return ans.next;
    }

    public static Node<Integer> mergeSort(Node<Integer> head) {

        if (head == null || head.next == null) return head;

        // find mid;
        Node<Integer> mid = findMid(head);
        Node<Integer> left = head;
        Node<Integer> right = mid.next;
        mid.next = null;

        // recursively sort left and right part
        left = mergeSort(left);
        right = mergeSort(right);

        // merge sorted List
        Node<Integer> result = mergeSortedList(left, right);

        return result;
    }
}
