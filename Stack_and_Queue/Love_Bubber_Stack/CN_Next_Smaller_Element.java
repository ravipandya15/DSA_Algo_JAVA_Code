package Stack_and_Queue.Love_Bubber_Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;;

public class CN_Next_Smaller_Element {
    
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = n-1; i >= 0; i--)
        {
            int cur = arr.get(i);
            while (st.peek() >= cur)
            {
                st.pop();
            }
            //ans.add(i, st.peek());
            //ans.set(i, st.peek());
            ans.add(st.peek());
            st.push(cur);
        }
        Collections.reverse(ans);
        return ans;
    }
    
}
