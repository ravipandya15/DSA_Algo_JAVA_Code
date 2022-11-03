package LinkedList_Series;

import java.util.Stack;

public class Next_Greater_Node_In_Linked_List_1019 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseLinkedList(ListNode head, int[] size)
    {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;

        while (cur != null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            size[0]++;
        }
        return prev;
    }
    public int[] nextLargerNodes(ListNode head) {
        int[] size = {0};
        ListNode reveseHead = reverseLinkedList(head, size);
        int[] ans = new int[size[0]];
        int index = size[0] - 1;
        Stack<Integer> st = new Stack<>();
        while (reveseHead != null)
        {
            while (!st.isEmpty() && st.peek() <= reveseHead.val)
            {
                st.pop();
            }
            if (!st.isEmpty()) ans[index--] = st.peek();
            else ans[index--] = 0;
            st.push(reveseHead.val);
            reveseHead = reveseHead.next;
        }
        return ans;
    }
}
