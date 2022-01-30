package LinkedList_Series;

import java.util.HashMap;
import java.util.Map;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class CN_Remove_Duplicates_From_Unsorted_Linked_List {
    
    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        if (head == null) return null;
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        LinkedListNode<Integer> cur = head;
        LinkedListNode<Integer> prev = null;

        while (cur != null)
        {
            if (map.containsKey(cur.data))
            {
                prev.next = cur.next;
                LinkedListNode<Integer> nodeToDelete = cur;
                cur = cur.next;
                nodeToDelete.next = null;
            }
            else
            {
                map.put(cur.data, true);
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
	}
}
