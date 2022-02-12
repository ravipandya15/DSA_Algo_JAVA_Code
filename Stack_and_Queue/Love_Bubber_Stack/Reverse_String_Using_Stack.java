package Stack_and_Queue.Love_Bubber_Stack;
import java.util.Stack;

public class Reverse_String_Using_Stack {
    
    public static String ReverseString(String str)
    {
        Stack<Character> st = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
        {
            st.push(str.charAt(i));
        }

        while (!st.isEmpty())
        {
            sb.append(st.peek());
            st.pop();
        }

        return sb.toString();
    }
        
}
