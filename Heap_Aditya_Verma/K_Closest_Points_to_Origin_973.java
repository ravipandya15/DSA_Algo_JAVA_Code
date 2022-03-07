package Heap_Aditya_Verma;

import java.util.Comparator;
import java.util.PriorityQueue;

class Pair
{
    int x;
    int y;
    int value;
}

public class K_Closest_Points_to_Origin_973 {
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> maxi = new PriorityQueue<>(
                new Comparator<Pair>() {
                    public int compare(Pair p1, Pair p2)
                    {
                        return p2.value - p1.value;
                    }
                }
        );

        for (int i = 0; i < points.length; i++)
        {
            Pair p = new Pair();
            p.x = points[i][0];
            p.y = points[i][1];
            p.value = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            maxi.add(p);
            if (maxi.size() > k)
            {
                maxi.poll();
            }
        }

        int[][] ans = new int[k][2];
        int index = 0;
        while (maxi.size() > 0)
        {
            ans[index][0] = maxi.peek().x;
            ans[index][1] = maxi.peek().y;
            index++;
            maxi.poll();
        }

        return ans;
    }

}
