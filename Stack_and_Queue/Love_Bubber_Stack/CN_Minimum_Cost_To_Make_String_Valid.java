package Stack_and_Queue.Love_Bubber_Stack;
import java.util.Stack;

public class CN_Minimum_Cost_To_Make_String_Valid {
    
    // TC -> O(N)
    // SC -> O(N)
    public static int findMinimumCost(String str) {
        // odd length
        if (str.length() % 2 == 1) return -1;

        // if any valid paranthesis found remove it
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch == '{')
            {
                st.push(ch);
            }
            else
            {// closing bracket
                if (!st.isEmpty() && st.peek() == '{')
                {
                    st.pop();
                }
                else
                {
                    st.push(ch);
                }
            }
        }

        // stack contains invalid characters
        int a = 0, b = 0;
        while (!st.isEmpty())
        {
            if (st.peek() == '{') b++;
            else if (st.peek() == '}') a++;
            st.pop();
        }

        int ans = (a+1)/2 + (b+1)/2;
        return ans;
    }
}
