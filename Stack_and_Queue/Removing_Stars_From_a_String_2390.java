package Stack_and_Queue;

import java.util.Stack;

public class Removing_Stars_From_a_String_2390 {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '*')
            {
                st.pop();
            }
            else
            {
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
        {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
