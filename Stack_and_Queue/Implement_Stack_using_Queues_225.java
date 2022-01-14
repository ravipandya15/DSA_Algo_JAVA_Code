package Stack_and_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Implement_Stack_using_Queues_225 {
    public static void main(String[] args)
    {
        System.out.println("Implement_Stack_using_Queues_225");

        MyStack obj = new MyStack();
        obj.Push(1);
        obj.Push(2);
        int param_2 = obj.Top();
        int param_5 = obj.Pop();
        //int param_3 = obj.Top();
        boolean param_4 = obj.Empty();
    }

    static class MyStack
    {
        Queue<Integer> q1 = new LinkedList<>();
        public MyStack()
        {

        }

        // using 1 queue
        public void Push(int x)
        {
            q1.add(x);
            for (int i = 0; i < q1.size() - 1; i++)
            {
                //q1.Enqueue(q1.Dequeue());
                q1.add(q1.peek());
                q1.poll();
            }
        }

        // using 2 queue
        public void Push1(int x)
        {
            Queue<Integer> q2 = new LinkedList<>();
            q2.add(x);
            while (!q1.isEmpty())
            {
                q2.add(q1.poll());
            }
            q1 = q2;
        }

        public int Pop()
        {
            return q1.poll(); 
        }

        public int Top()
        {
            return q1.peek();
        }

        public boolean Empty()
        {
            return q1.isEmpty();
        }
    }
}
