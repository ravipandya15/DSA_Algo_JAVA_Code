package Stack_and_Queue.Love_Bubber_Stack;
import java.util.Stack;
public class GFG_The_Celebrity_Problem {
    
    private static boolean knows(int a, int b, int M[][], int n)
    {
        if (M[a][b] == 1) return true;
        return false;
    }
    
    // TC -> O(N)
    // SC -> O(N)
    int celebrity(int M[][], int n)
    {
    	// step 1 -> push all indexes in Stack
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < n; i++)
        {
            st.push(i);
        }

        // step 2
        while (st.size() > 1)
        {
            int a = st.peek();
            st.pop();

            int b = st.peek();
            st.pop();

            if (knows(a, b, M, n)) // check if a knows b or not
            {
                // ingore a and push b
                st.push(b);
            }
            else{
                st.push(a);
            }
        }

        // now only 1 element is there in stack whih might be Potential solution
        // verify
        int ans = st.peek();
        int rowCount = 0;
        for (int i = 0; i < n; i++)
        {
            if (M[ans][i] == 0) rowCount++;
        }

        if (rowCount != n) return -1;

        int colCount = 0;
        for (int i = 0; i < n; i++)
        {
            if (M[i][ans] == 1) colCount++;
        }

        if (colCount != n-1) return -1;
        return ans;
    }
}
