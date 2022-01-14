package Stack_and_Queue;

import java.util.Stack;

public class Valid_Parentheses_20 {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                st.push(s.charAt(i));
            else
            {
                if (st.isEmpty()) return false;
                char ch = st.peek();
                st.pop();
                if ( (s.charAt(i) == ')' && ch == '(') ||
                    (s.charAt(i) == '}' && ch == '{')  ||
                    (s.charAt(i) == ']' && ch == '[')  )
                {

                }
                else
                {
                    return false;
                }
            }
        }

        if (st.isEmpty()) return true;
        return false;
    }
}
