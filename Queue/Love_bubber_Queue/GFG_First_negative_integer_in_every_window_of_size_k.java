package Queue.Love_bubber_Queue;

import java.util.Deque;
import java.util.LinkedList;

public class GFG_First_negative_integer_in_every_window_of_size_k {
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Deque<Integer> deque = new LinkedList<Integer>();
        long[] ans = new long[N-K+1];
        int index = 0;

        // for 1st K sized window
        for (int i = 0; i < K; i++)
        {
            if (A[i] < 0)
            {
                deque.addLast(i);
            }
        }

        // store ans for 1st window
        if (!deque.isEmpty())
        {
            ans[index] = A[deque.getFirst()];
        }
        else
        {
            ans[index] = 0;
        }
        index++;

        // for remaining K sized Window
        for (int i = K; i < N; i++)
        {
            // removal code
            if (!deque.isEmpty() && i - deque.getFirst() >= K)
            {
                deque.removeFirst();
            }

            // adding code
            if (A[i] < 0)
            {
                deque.addLast(i);
            }

            // store ans
            if (!deque.isEmpty())
            {
                ans[index] = A[deque.getFirst()];
            }
            else
            {
                ans[index] = 0;
            }
            index++;
        }
        return ans;
    }
}
