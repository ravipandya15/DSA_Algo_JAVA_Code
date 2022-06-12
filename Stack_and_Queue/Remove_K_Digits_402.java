package Stack_and_Queue;

import java.util.Stack;

public class Remove_K_Digits_402 {
    
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k > n) return "0";

        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < n; i++)
        {
            while (!st.isEmpty() && k > 0 && st.peek() > num.charAt(i))
            {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while (k > 0)
        {
            st.pop();
            k--;
        }

        if (st.isEmpty()) return "0";
        String ans = "";

        while (!st.isEmpty())
        {
            ans = st.peek() + ans;
            st.pop();
        }

        int i = 0;
        int size = ans.length();
        while (i < size && ans.charAt(i) == '0') i++;

        return ans.substring(i) == "" ? "0" : ans.substring(i);
    }

}
