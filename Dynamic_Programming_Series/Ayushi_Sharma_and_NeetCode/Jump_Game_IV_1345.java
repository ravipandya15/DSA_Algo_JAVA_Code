package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Jump_Game_IV_1345 {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            if (map.containsKey(arr[i]))
            {
                map.get(arr[i]).add(i);
            }
            else
            {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int step = 0;
        while (!q.isEmpty())
        {
            for (int size = q.size(); size > 0; size--)
            {
                int i = q.peek();
                q.poll();
                if (i == n-1) return step;
                List<Integer> next = map.get(arr[i]);
                next.add(i+1);
                next.add(i-1);
                for (Integer j : next)
                {
                    if (j >= 0 && j < n && !visited[j])
                    {
                        visited[j] = true;
                        q.add(j);
                    }
                }
                map.get(arr[i]).clear(); // IMP -> key will exist -> just clear the list value associated with that key
            }
            step++;
        }
        return 0;
    }
}
