package Stack_and_Queue.Love_Bubber_Stack;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Cn_Reverse_The_Groups {
    
    
    static void reverse(int[] v, int start, int end)
    {
        while (start <= end)
        {
            int temp = v[start];
            v[start] = v[end];
            v[end] = temp;
            start++;
            end--;
        }
    }

    // working
    static Stack<Integer> reverseTheGroups(Stack<Integer> s, int n, int k)
    {

        int[] v = new int[n];
        int index = 0;
        while (s.size() > 0)
        {
            v[index] = s.peek();
            s.pop();
            index++;
        }

        int a = v.length / k;
        int j = 0;

        while (a > 0)
        {
            reverse(v, j, j + k - 1);
            j = j + k;
            a--;
        }

        Collections.reverse(Arrays.asList(a));

        for (int i = 0; i < v.length; i++)
        {
            s.push(v[i]);
        }
        return s;
    }

}
