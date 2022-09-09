package Stack_and_Queue;

import java.util.Stack;

public class Daily_Temperatures_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i >= 0; i--)
        {
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i])
            {
                st.pop();
            }
            if (st.isEmpty())
            {
                result[i] = 0;
            }
            else
            {
                result[i] = st.peek() - i;
            }
            st.add(i);
        }
        return result;
    }
}
