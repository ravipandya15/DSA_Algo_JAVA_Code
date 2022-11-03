package Heap_Love_Babbar.Extra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class Maximum_Performance_of_a_Team_1383 {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = (int)1e9 + 7;
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            list.add(new Pair<Integer,Integer>(efficiency[i], speed[i]));
        }

        Collections.sort(list, (a, b) -> b.getKey() - a.getKey());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        long result = 0;
        long totalSpeed = 0;
        long currentEfficiency = 0;
        long currentSpeed = 0;
        for (int i = 0; i < n; i++)
        {
            currentEfficiency = list.get(i).getKey();
            currentSpeed = list.get(i).getValue();
            if (pq.size() == k)
            {
                totalSpeed -= pq.poll();
            }

            totalSpeed += currentSpeed;
            result = Math.max(result, currentEfficiency * totalSpeed);
            pq.add(currentSpeed);
        }
        return (int)(result % mod);
    }
}
