package Stack_and_Queue;

import java.util.Stack;

public class Min_Stack_155 {
    
    class MinStack {

        Long mini;
        Stack<Long> st = new Stack<Long>();

        public MinStack() {
            mini = Long.MAX_VALUE;
        }
        
        public void push(int value) {
            Long val = Long.valueOf(value);
            if (st.size() == 0)
            {
                // first element
                mini = val;
                st.push(val);
            }
            else
            {
                if (val < mini)
                {
                    // update mini and push modified value
                    st.push(2 * val - mini);
                    mini = val;
                }
                else
                {
                    st.push(val);
                }
            }
        }
        
        public void pop() {
            if (st.size() == 0) return;
            Long val = st.peek();
            st.pop();

            if (val < mini)
            {
                // it means it's modified value so roll back mini to prevMin.
                mini = 2 * mini - val;
            }
        }
        
        public int top() {
            Long val = st.peek();

            if (val < mini)
            {
                return mini.intValue();
            }
            return val.intValue();
        }
        
        public int getMin() {
            return mini.intValue();
        }
    }

}
