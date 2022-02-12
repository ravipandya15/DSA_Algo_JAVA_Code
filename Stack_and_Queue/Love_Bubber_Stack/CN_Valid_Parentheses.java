package Stack_and_Queue.Love_Bubber_Stack;
import java.util.Stack;

public class CN_Valid_Parentheses {
    
    public static boolean isValidParenthesis(String expression) {
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < expression.length(); i++)
        {
            if (expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[')
            {
                st.push(expression.charAt(i));
            }
            else
            {
                if (st.isEmpty()) return false;
                char ch = st.peek();

                if ((expression.charAt(i) == ')' && ch == '(') 
                    || (expression.charAt(i) == '}' && ch == '{')
                    || (expression.charAt(i) == ']' && ch == '['))
                    {
                        st.pop();
                    }
                    else
                    {
                        return false;
                    }
            }
        }

        return st.isEmpty();
    }

    public static boolean isValidParenthesis2(String expression) {
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < expression.length(); i++)
        {
            if (expression.charAt(i) == '(')
                st.push(')');
            else if (expression.charAt(i) == '{')
                st.push('}');
            else if (expression.charAt(i) == '[')
                st.push(']');
            else if (st.isEmpty() || expression.charAt(i) != st.pop())
                return false;
        }

        return st.isEmpty();
    }

}
