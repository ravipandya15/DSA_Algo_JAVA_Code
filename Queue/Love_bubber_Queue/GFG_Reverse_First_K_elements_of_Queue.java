package Queue.Love_bubber_Queue;

import java.util.Queue;
import java.util.Stack;

public class GFG_Reverse_First_K_elements_of_Queue {
    
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < k; i++)
        {
            st.push(q.peek());
            q.poll();
        }

        while (!st.isEmpty())
        {
            q.add(st.peek());
            st.pop();
        }

        int t = q.size() - k;

        while (t > 0)
        {
            int data = q.peek();
            q.poll();
            q.add(data);
            t--;
        }

        return q;
    }

}
