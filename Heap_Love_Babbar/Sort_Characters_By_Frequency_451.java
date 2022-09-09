package Heap_Love_Babbar;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class Sort_Characters_By_Frequency_451 {

    class Pair
    {
        char character;
        int count;
        public Pair(char character, int count) {
            this.character = character;
            this.count = count;
        }
        public Pair() {}
    }

    public String frequencySort(String s) {
        StringBuilder ans = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> maxi = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);
        int n = s.length();
        for (int i = 0; i < n; i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Pair p = new Pair();
            p.character = entry.getKey();
            p.count = entry.getValue();
            maxi.add(p);
        }
        while (!maxi.isEmpty())
        {
            Pair p = maxi.poll();
            int count = p.count;
            while (count > 0)
            {
                ans.append(p.character);
                count--;
            }
        }
        return ans.toString();
    }
}
