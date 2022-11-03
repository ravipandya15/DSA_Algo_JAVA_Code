package Stack_and_Queue;

import java.util.Stack;

public class Asteroid_Collision_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        boolean flag = true;
        for (int val : asteroids)
        {
            flag = true;
            while (!st.isEmpty() && st.peek() > 0 && val < 0)
            {
                if (Math.abs(st.peek()) < Math.abs(val))
                {
                    st.pop();
                }
                else if (Math.abs(st.peek()) == Math.abs(val))
                {
                    st.pop();
                    flag = false;
                    break;
                }
                else
                {
                    flag = false;
                    break;
                }
            }
            if (flag) st.push(val);
        }
        int n = st.size();
        int[] result = new int[n];
        int index = n - 1;
        while (!st.isEmpty())
        {
            result[index--] = st.pop();
        }
        return result;
    }
}
