package Stack_and_Queue.Love_Bubber_Stack;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

public class Largest_Rectangle_in_Histogram_84_Love_Bubber {

    public static int[] findNextSmallerElement(int[] heights, int n)
    {
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        int[] ans = new int[n];

        for (int i = n-1; i >= 0; i--)
        {
            int cur = heights[i];
            while (st.peek() != -1 && heights[st.peek()] >= cur)
            {
                st.pop();
            }
            ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }

    public static int[] findPreviousSmallerElement(int[] heights, int n)
    {
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        int[] ans = new int[n];

        for (int i = 0; i < n; i++)
        {
            int cur = heights[i];
            while (st.peek() != -1 && heights[st.peek()] >= cur)
            {
                st.pop();
            }
            ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] next = findNextSmallerElement(heights, n);
        int[] prev = findPreviousSmallerElement(heights, n);

        int area = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            int l = heights[i];
            if (next[i] == -1)
            {
                next[i] = n;
            }
            int b = next[i] - prev[i] - 1;
            area = Math.max(area, (l * b));
        }
        return area;
    }
}
