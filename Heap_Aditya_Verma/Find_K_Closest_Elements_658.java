package Heap_Aditya_Verma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;



public class Find_K_Closest_Elements_658 {
    class Pair
    {
        int first;
        int second;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<Integer>();
         PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
             new Comparator<Pair>() {
                 public int compare(Pair o1, Pair o2)
                 {
                     if (o2.first == o1.first)
                     {
                        return o2.second - o1.second;
                     }
                     return o2.first - o1.first;
                 }
             }
         );
        for (int i = 0; i < arr.length; i++)
        {
            Pair p = new Pair();
            p.first = Math.abs(arr[i] - x);
            p.second = arr[i];
            pq.add(p);

            if (pq.size() > k)
            {
                pq.poll();
            }
        }

        while (pq.size() > 0)
        {
            ans.add(pq.peek().second);
            pq.poll();
        }

        Collections.sort(ans);

        return ans;
    }
}
