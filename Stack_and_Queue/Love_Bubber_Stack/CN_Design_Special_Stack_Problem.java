package Stack_and_Queue.Love_Bubber_Stack;

import java.util.Stack;

class SpecialStack {
	Stack<Integer> st = new Stack<Integer>();
    int mini; // here mini = INT_MAX will work but it's not required as in push operation for 1st element we are updating mini.
	

	/*----------------- Public Functions of SpecialStack -----------------*/

	void push(int data) {
		// for 1st element
        if (st.isEmpty())
        {
            st.push(data);
            mini = data;
        }
        else
        {
            if (data < mini)
            {
                int val = 2*data - mini;
                st.push(val);
                mini = data;
            }
            else
            {
                st.push(data);
            }
        }
	}

	int pop() {
		// underflow condition
        if (st.isEmpty()) return -1;

        int cur = st.peek();
        st.pop();
        if (cur > mini)
        {
            return cur;
        }
        else
        {
            int prevMin = mini;
            int val = 2*mini - cur;
            mini = val;
            return prevMin;
        }
	}

	int top() {
		if (st.isEmpty()) return -1;

        int cur = st.peek();
        if (cur < mini)
        {
            return mini;
        }
        else
        {
            return cur;
        }
	}

	boolean isEmpty() {
		return st.isEmpty();
	}

	int getMin() {
        if (st.isEmpty()) return -1;
		return mini;
	}
}



public class CN_Design_Special_Stack_Problem {
    
}
