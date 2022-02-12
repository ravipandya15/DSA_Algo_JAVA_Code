package Stack_and_Queue.Love_Bubber_Stack;
import java.util.Stack;
public class GFG_Max_rectangle {
    
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

    private static int largestRectangleArea(int[] heights) {
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

    // TC -> O(n * m)
    // SC -> O(m)
    public int maxArea(int M[][], int n, int m) {
        // step 1 -> compute max area for 1st row
        int area = largestRectangleArea(M[0]);

        // step 2 -> compute max area for remaining row
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (M[i][j] != 0)
                {
                    M[i][j] += M[i-1][j];
                }
                else
                {
                    M[i][j] = 0;
                }
            }

            area = Math.max(area, largestRectangleArea(M[i]));
        }

        return area;
    }

}
