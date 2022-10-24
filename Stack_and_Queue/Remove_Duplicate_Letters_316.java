package Stack_and_Queue;

import java.util.Stack;

public class Remove_Duplicate_Letters_316 {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] lastIndex = new int[26];
        for (int i = 0; i < n; i++)
        {
            lastIndex[s.charAt(i) - 'a'] = i; 
        }

        Stack<Character> st = new Stack<Character>();
        boolean[] seen = new boolean[26];

        for (int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            if (seen[ch - 'a'] == true)
            {
                continue;
            }

            while (!st.isEmpty() && ch < st.peek() && lastIndex[st.peek() - 'a'] > i)
            {
                seen[st.peek() - 'a'] = false;
                st.pop();
            }
            seen[ch - 'a'] = true;
            st.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
        {
            sb.append(st.pop());
        }

        int start = 0, end = sb.length() - 1;
        while (start < end)
        {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }

        return sb.toString();
    }
}
