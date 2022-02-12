package Stack_and_Queue.Love_Bubber_Stack;
import java.util.Stack;

public class CN_Redundant_Brackets {
    
    public static boolean findRedundantBrackets(String s) 
    {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/')
                st.push(ch);
            else
            {
                // it's ')' or lower case letter
                if (ch == ')')
                {
                    boolean isRedundant = true;
                    while (st.peek() != '(') // as it's a valid mathematical expressions we definately find '(' bracket
                    {
                        char top = st.peek();
                        if (top == '+' || top == '-' || top == '*' || top == '/')
                        {
                            isRedundant = false;
                        }
                        st.pop();
                    }

                    if (isRedundant) return true;
                    st.pop(); //-> to remove '('
                }
            }
        }
        return false;
    }
}
