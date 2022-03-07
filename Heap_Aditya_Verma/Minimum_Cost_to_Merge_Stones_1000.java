package Heap_Aditya_Verma;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Pair
{
    int sum;
    int index;
    ArrayList<Integer> list = new ArrayList<Integer>();
}
public class Minimum_Cost_to_Merge_Stones_1000 {
    
    // Not working


    public static void main(String[] args) {
        int[] stones = {3,2,4,1};
        int k = 3;
        int result = mergeStones(stones, k);
        System.out.println(result);
    }
    public static void removeElements(ArrayList<Integer> list, List<Integer> stoneList, PriorityQueue<Pair> mini)
    {
        for (int item : list)
        {
            //stoneList.remove(new Integer(item));
        }

        for (int item : list)
        {
            for (Pair p : mini)
            {
                if (p.list.contains(item))
                {
                    mini.remove(p);
                }
            }
        }
    }


    public static int mergeStones(int[] stones, int k) {
        int n = stones.length;

        List<Integer> stoneList = Arrays.stream(stones).boxed().collect(Collectors.toList());

        PriorityQueue<Pair> mini = new PriorityQueue<Pair>(
            new Comparator<Pair>() {
                public int compare(Pair p1, Pair p2)
                {
                    return p1.sum - p2.sum;
                }
            }
        );

        for (int i = 0; i < n - k + 1; i++)
        {
            Pair p = new Pair();
            p.index = i;
            for (int j = i; j < i + k; j++)
            {
                p.sum += stoneList.get(j);
                p.list.add(stoneList.get(j));
                mini.add(p);
            }
        }

        int result = 0;

        while (stoneList.size() > 1)
        {
            // edge case
            if (stoneList.size() < k)
            {
                return -1;
            }

            Pair p = mini.peek();
            int tempSum = p.sum;
            result += tempSum;

            int index = p.index;
            removeElements(p.list, stoneList, mini);
            stoneList.add(index, tempSum); 

            // add new pair in PriorityQueue
            Pair p1 = new Pair();
            int i = index - 1;
            if (i < 0)
            {
                i = 0;
            }
            p1.index = i;
            for (int j = i; j < k; j++)
            {
                p1.sum += stoneList.get(j);
                p1.list.add(stoneList.get(j));
            }
            mini.add(p1);
        }

        return result;
    }
}
