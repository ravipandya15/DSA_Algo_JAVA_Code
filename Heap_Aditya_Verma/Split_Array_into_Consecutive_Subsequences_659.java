package Heap_Aditya_Verma;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Split_Array_into_Consecutive_Subsequences_659 {

    class Pair
    {
        int data;
        int count;
        public Pair(int data, int count)
        {
            this.data = data;
            this.count = count;
        }
    }
    public boolean isPossible(int[] nums) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>()
        {
            @Override
            public int compare(Pair p1, Pair p2)
            {
                if (p2.count == p1.count)
                {
                    return p1.data - p2.data;
                }
                return p2.count - p1.count;
            }
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int length = 0;
        while (!map.isEmpty())
        {
            Pair p = pq.poll();
            if (!map.containsKey(p.data)) return false;
            length++;
            p.count--;
            if (p.count == 0)
            {
                map.remove(p.data);
            }
            else
            {
                map.put(p.data, p.count);
                pq.add(p);
            }
            int data = p.data;
            while (map.containsKey(data + 1))
            {
                
                map.put(data + 1, map.get(data + 1) - 1);
                if (map.get(data + 1) == 0) map.remove(data + 1);
                length++;
                data++;
            }
            if (length < 3) return false;
            length = 0;
        }
        return true;
    }
}
