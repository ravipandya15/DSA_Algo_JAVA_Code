package Heap_Aditya_Verma;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class K_th_Largest_Element_in_an_Array_215 {

    // TC -> O(NLogK)
    public int findKthLargest(int[] nums, int k) {
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

        return mini.peek();
    }

    // TC -> O(NLogK)
    public int findKthSmallest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        PriorityQueue<Integer> maxi = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < n; i++)
        {
            maxi.add(nums[i]);

            if (maxi.size() > k)
            {
                maxi.poll();
            }
        }

        return maxi.peek();
    }
}
