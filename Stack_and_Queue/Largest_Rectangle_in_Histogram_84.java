package Stack_and_Queue;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram_84 {
    public static void main(String[] args)
    {
        System.out.println("84. Largest Rectangle in Histogram");
        int[] arr = new int[] { 2, 1, 5, 6, 2, 3, 1 };
        System.out.println("Largest Rectangle Area is " + LargestRectangleArea(arr));
    }

    // Optimal don't say this solution in interview as it is very hard to convey
    public static int LargestRectangleArea1(int[] heights)
    {
        Stack<Integer> stack = new Stack<Integer>();
        int n = heights.length;
        int max = 0;
        for (int i = 0; i <= n; i++)
        {
            while (!stack.empty()  && (i == n || heights[stack.peek()] >= heights[i]))
            {
                int height = heights[stack.peek()];
                stack.pop();
                int width;
                if (stack.empty() ) width = i;
                else width = i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }

    // TC -> O(N)
    // SC -> O(N)
    public static int LargestRectangleArea(int[] heights)
    {
        Stack<Integer> stack = new Stack<Integer>();
        int n = heights.length;
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];

        // left small
        for (int i = 0; i < n; i++)
        {
            while (!stack.empty() && heights[stack.peek()] >= heights[i])
                stack.pop();

            if (stack.empty()) leftSmall[i] = 0;
            else leftSmall[i] = stack.peek() + 1;

            stack.push(i);
        }

        // clear stack as it will be re - used for right small
        while (!stack.empty()) stack.pop();

        // right small
        for (int i = n - 1; i >= 0; i--)
        {
            while (!stack.empty() && heights[stack.peek()] >= heights[i])
                stack.pop();

            if (stack.empty()) rightSmall[i] = n - 1;
            else rightSmall[i] = stack.peek() - 1;

            stack.push(i);
        }

        // compute max area
        int max = 0;
        for (int i = 0; i < n; i++)
        {
            max = Math.max(max, (rightSmall[i] - leftSmall[i] + 1) * heights[i]);
        }

        return max;
    }
}
