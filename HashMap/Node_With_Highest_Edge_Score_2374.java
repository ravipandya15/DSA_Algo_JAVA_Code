package HashMap;

import java.util.HashMap;
import java.util.Map;

public class Node_With_Highest_Edge_Score_2374 {
    public int edgeScore(int[] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        int highestNode = 0;
        for (int i = 0; i < edges.length; i++)
        {
            map.put(edges[i], map.getOrDefault(edges[i], 0) + i);
            int lastValue = map.get(edges[i]);
            int highestValue = map.getOrDefault(highestNode, 0);
            if (lastValue > highestValue)
            {
                highestNode = edges[i];
            }
            else if (lastValue == highestValue)
            {
                highestNode = Math.min(highestNode, edges[i]);
            }
        }
        return highestNode;
    }

    public int edgeScore_1(int[] edges) {
        Map<Integer, Long> map = new HashMap<Integer, Long>();
        int n = edges.length;
        for (int i = 0; i < n; i++)
        {
            if (map.containsKey(edges[i]))
            {
                map.put(edges[i], map.get(edges[i]) + i);
            }
            else
            {
                map.put(edges[i], Long.valueOf(i));
            }
            //map.put(edges[i], map.getOrDefault(edges[i], 0) + Long.valueOf(i));
        }
        long maxi = Long.MIN_VALUE;
        int ans = 0;

        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            if (entry.getValue() > maxi)
            {
                ans = entry.getKey();
                maxi = entry.getValue();
            }
            else if (entry.getValue() == maxi)
            {
                ans = Math.min(ans, entry.getKey());
            }
        }
        return ans;
    }
}
