package Stack_and_Queue;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String s : tokens)
        {
            if (s.equals("*") || s.equals("/")|| s.equals("+") || s.equals("-"))
            {
                int second = st.pop();
                int first = st.pop();
                if (s.equals("*"))
                {
                    //System.out.println("added value is " + (first * second));
                    st.push(first * second);
                }
                else if (s.equals("/"))
                {
                    //System.out.println("added value is " + (first / second));
                    st.push(first / second);
                }
                else if (s.equals("+"))
                {
                    //System.out.println("added value is " + (first + second));
                    st.push(first + second);
                }
                else 
                {
                    //System.out.println("added value is " + (first - second));
                    st.push(first - second);
                }
            }
            else
            {
                //int value = Integer.parseInt(s);
                //System.out.println("value is " + value);
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
