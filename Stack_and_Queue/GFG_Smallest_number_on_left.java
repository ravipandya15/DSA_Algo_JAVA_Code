package Stack_and_Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GFG_Smallest_number_on_left {
    
    static List<Integer> leftSmaller(int n, int a[])
    {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < a.length; i++)
        {
            while (!st.empty() && st.peek() >= a[i])
            {
                st.pop();
            }
            if (st.empty())
            {
                ans.add(-1);
            }
            else
            {
                ans.add(st.peek());
            }
            st.push(a[i]);
        }

        return ans;
    }
}
