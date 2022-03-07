package Heap_Aditya_Verma;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;

class Pair
{
    int first;
    int second;
}

public class Top_K_Frequent_Elements_347 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        int[] ans = topKFrequent(nums, 2);

        for (int i = 0; i < ans.length; i++)
        {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            //map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.containsKey(nums[i]))
            {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else
            {
                map.put(nums[i], 1);
            }
        }

        // PriorityQueue<Pair> mini = new PriorityQueue<>(
        //     new Comparator<Pair>() {
        //         public int compare(Pair o1, Pair o2)
        //         {
        //             return o1.first - o2.first;
        //         }
        //     }
        // );
        PriorityQueue<Pair> mini = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> i : map.entrySet())
        {
            Pair p = new Pair();
            p.first = i.getValue();
            p.second = i.getKey();
            mini.add(p);

            if (mini.size() > k)
            {
                mini.poll();
            }
        }
        int index = 0;

        while (mini.size() > 0)
        {
            ans[index++] = mini.peek().second;
            mini.poll();
        }
        return ans;
    }
}
