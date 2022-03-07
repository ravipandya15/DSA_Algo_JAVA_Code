package Heap_Aditya_Verma;

import java.util.PriorityQueue;

public class Sort_K_Sorted_Array {
    
    // TC -> O(NLogK)
    // also known as Sort nearly sorted array
    // ased in Flipkart
    // used Max Heap
    public static int[] sortKSortedArray(int[] nums, int k)
    {
        int n = nums.length;
        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++)
        {
            pq.add(nums[i]);
            if (pq.size() > k)
            {
                nums[index++] = pq.peek();
                pq.poll();
            }
        }

        while (pq.size() > 0)
        {
            nums[index++] = pq.peek();
            pq.poll();
        }

        return nums;
    }

    // code studio
    public static int[] nearlySorted(int[] array, int n, int k) {
        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++)
        {
            pq.add(array[i]);
            if (pq.size() > k)
            {
                array[index++] = pq.peek();
                pq.poll();
            }
        }

        while (pq.size() > 0)
        {
            array[index++] = pq.peek();
            pq.poll();
        }
        return array;
    }
}
