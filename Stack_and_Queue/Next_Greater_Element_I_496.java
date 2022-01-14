package Stack_and_Queue;

import java.util.HashMap;
import java.util.Stack;

public class Next_Greater_Element_I_496 {
    public static void Main(String[] args)
    {
        System.out.println("496. Next Greater Element I");
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();

        // as array is dictinct as per question
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = nums2.length - 1; i >= 0; i--)
        {
            while (!stack.isEmpty() && stack.peek() <= nums2[i])
                stack.pop();

            if (stack.isEmpty())
                map.put(nums2[i], -1);
            else
                map.put(nums2[i], stack.peek());

            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++)
        {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
