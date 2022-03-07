package Heap_Aditya_Verma;

import java.util.Collections;
import java.util.PriorityQueue;

public class GFG_Sum_of_elements_between_k1th_and_k2th_smallest_elements {
    
    private static long KthSmallestElement(long A[], long N, long k)
    {
        PriorityQueue<Long> mini = new PriorityQueue<Long>(Collections.reverseOrder());
        for (int i = 0; i < N; i++)
        {
            mini.add(A[i]);
            if (mini.size() > k)
            {
                mini.poll();
            }
        }

        return mini.peek();
    }

    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2)
    {
        long first = KthSmallestElement(A, N, K1);
        long second = KthSmallestElement(A, N, K2);

        long sum = 0;
        for (int i = 0; i < N; i++)
        {
            if (A[i] > first && A[i] < second)
            {
                sum = sum + A[i];
            }
        }

        return sum;
    }
}
