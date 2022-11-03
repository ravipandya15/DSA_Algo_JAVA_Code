package Stack_and_Queue;

import java.util.Stack;

import javafx.util.Pair;

public class Java_132_Pattern_456 {
    public boolean find132pattern(int[] nums) {
        Stack<Pair<Integer, Integer>> st = new Stack<>(); // monotonically decreasing
        int curMin = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            while (!st.isEmpty() && st.peek().getKey() <= nums[i])
            {
                st.pop();
            }
            if (!st.isEmpty() && nums[i] > st.peek().getValue())
            {
                return true;
            }

            st.add(new Pair<Integer,Integer>(nums[i], curMin)); // it's not necessary that curMin < nums[i]
            // curMin indicates till now this is the min value
            curMin = Math.min(curMin, nums[i]);
        }
        return false;
    }
}
