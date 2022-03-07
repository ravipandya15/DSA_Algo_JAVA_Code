package Heap_Aditya_Verma;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Pair
{
    int value;
    int freq;
}

public class Sort_Array_by_Increasing_Frequency_1636 {
    
    public int[] frequencySort(int[] nums) {
        int size = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
            new Comparator<Pair>() {
                public int compare(Pair p1, Pair p2)
                {
                    if (p1.freq == p2.freq)
                    {
                        return p2.value - p1.value;
                    }
                    return p1.freq - p2.freq;
                }
            }
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            Pair p = new Pair();
            p.freq = entry.getValue();
            p.value = entry.getKey();
            pq.add(p);
        }

        int[] ans = new int[size];
        int index = 0;
        while (pq.size() > 0)
        {
            int freq = pq.peek().freq;
            int value = pq.peek().value;
            for (int i = 0; i < freq; i++)
            {
                ans[index++] = value;
            }
            pq.poll();
        }

        return ans;
    }

}
