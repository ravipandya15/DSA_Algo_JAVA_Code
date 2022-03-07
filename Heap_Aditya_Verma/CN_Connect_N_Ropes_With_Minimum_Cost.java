package Heap_Aditya_Verma;

import java.util.PriorityQueue;

public class CN_Connect_N_Ropes_With_Minimum_Cost {
    
    public static long connectRopes(int[] arr)
    {
        PriorityQueue<Integer> mini = new PriorityQueue<Integer>();
        for (int i = 0; i < arr.length; i++)
        {
            mini.add(arr[i]);
        }

        long cost = 0;
        while (mini.size() > 1)
        {
            int first = mini.peek();
            mini.poll();
            int second = mini.peek();
            mini.poll();

            cost += first + second;
            mini.add(first + second);
        }

        return cost;
    }
}
