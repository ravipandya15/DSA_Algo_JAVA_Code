package Queue.Love_bubber_Queue;

import java.util.Queue;
import java.util.Stack;

public class GFG_Queue_Reversal {
    
    public Queue<Integer> rev(Queue<Integer> q){
        Stack<Integer> st = new Stack<Integer>();

        while (!q.isEmpty())
        {
            st.push(q.peek());
            q.poll();
        }

        while (!st.isEmpty())
        {
            q.add(st.peek());
            st.pop();
        }

        return q;
    }
}
