package Heap_Aditya_Verma;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Return_K_Largest_Element_In_Array {

    // Codestudios
    public static int[] Klargest(int[] a, int k, int n) {
        int[] ans = new int[k];
        PriorityQueue<Integer> mini = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++)
        {
            mini.add(a[i]);

            if (mini.size() > k)
            {
                mini.poll();
            }
        }

        int index = 0;
        while (!mini.isEmpty())
        {
            ans[index++] = mini.peek();
            mini.poll();
        }

        return ans;
    }
    
    public static ArrayList<Integer> KLargestElements(int[] nums, int k)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = nums.length;
        PriorityQueue<Integer> mini = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++)
        {
            mini.add(nums[i]);

            if (mini.size() > k)
            {
                mini.poll();
            }
        }

        while (!mini.isEmpty())
        {
            list.add(mini.peek());
            mini.poll();
        }

        return list;
    }
}
