package LinkedList_Series;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class CN_Merge_Two_Sorted_Linked_Lists {
    public static LinkedListNode<Integer> solve(LinkedListNode<Integer> first, LinkedListNode<Integer> second)
    {
        // check if fist list only contails 1 node
        if (first.next == null)
        {
            first.next = second;
            return first;
        }

        LinkedListNode<Integer> cur1 = first;
        LinkedListNode<Integer> next1 = first.next; // as we already check empty list cases
        LinkedListNode<Integer> cur2 = second;
        LinkedListNode<Integer> next2 = second.next;

        while (next1 != null && cur2 != null)
        {
            if (cur2.data >= cur1.data && cur2.data <= next1.data)
            {
                cur1.next = cur2;
                next2 = cur2.next;
                cur2.next = next1;

                cur1 = cur2; // or cur1 = cur1.next;
                cur2 = next2;
            }
            else
            {
                cur1 = next1;
                next1 = next1.next;
            }
        }

        if (next1 == null)
        {
            cur1.next = cur2;
        }

        return first;
    }

    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		if (first == null) return second;
        if (second == null) return first;

        if (first.data <= second.data)
        {
            return solve(first, second);
        }
        else
        {
            return solve(second, first);
        }
	}

}
