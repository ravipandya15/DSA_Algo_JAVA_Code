package Stack_and_Queue;

import java.util.Stack;

// leetcode 232
public class Implement_queue_using_Stacks {
    public static void main(String[] args)
    {
        System.out.println("232.Implement_queue_using_Stacks");
        MyQueue obj = new MyQueue();
        obj.Push(2);
        obj.Push(5);
        obj.Push(3);
        int o1 = obj.Peek();
        int o2 = obj.Pop();
        obj.Push(6);
        int o3 = obj.Pop();
        int o4 = obj.Pop();
        int o5 = obj.Peek();
        boolean o6 = obj.Empty();
    }

    static class MyQueue
    {
        // approach 1;
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        // approach 2;
        Stack<Integer> input = new Stack<Integer>();
        Stack<Integer> output = new Stack<Integer>();
        public MyQueue()
        {

        }

        //approach 2
        public void Push(int x)
        {
            input.push(x);
        }

        //approach 2
        public int Pop()
        {
            if (!output.isEmpty())
                return output.pop();
            else
            {
                // empty stack
                while (!input.isEmpty())
                {
                    output.push(input.peek());
                    input.pop();
                }
                return output.pop();
            }
        }

        //approach 2
        public int Peek()
        {
            if (!output.isEmpty())
                return output.peek();
            else
            {
                // empty stack
                while (!input.isEmpty())
                {
                    output.push(input.peek());
                    input.pop();
                }
                return output.peek();
            }
        }

        //approach 1
        public void Push1(int x)
        {
            while (!s1.isEmpty())
            {
                s2.push(s1.peek());
                s1.pop();
            }
            s1.push(x);
            while (!s2.isEmpty())
            {
                s1.push(s2.peek());
                s2.pop();
            }
        }

        //approach 1
        public int Pop1()
        {
            return s1.pop();
        }

        //approach 1
        public int Peek1()
        {
            return s1.peek();
        }

        public boolean Empty()
        {
            // approach 1
            //return s1.isEmpty();
            // approach 2
            return (input.isEmpty() && output.isEmpty());
        }
    }
}
