package Heap_Aditya_Verma;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class The_K_Weakest_Rows_in_a_Matrix_1337 {

    public static int countSoldiers(int[] mat)
    {
        int low = 0, high = mat.length - 1;
        int mid = low + (high - low)/2;

        while (low <= high)
        {
            if (mat[mid] == 0)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
            mid = low + (high - low)/2;
        }
        return low;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair<Integer, Integer>> max_heap = new PriorityQueue<>(
            new Comparator<Pair<Integer, Integer>>() {

                @Override
                public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b)
                {
                    // if (a.getKey() > b.getKey()) return 1;
                    // else if (a.getKey() < b.getKey()) return -1;
                    // else
                    // {
                    //     if (a.getValue() < b.getValue()) return -1;
                    //     return 1;
                    // }
                    if (a.getKey() == b.getKey())
                    {
                        return b.getValue() - a.getValue();
                    }
                    return b.getKey() - a.getKey();
                }
            }
        );

        for (int i = 0; i < mat.length; i++)
        {
            max_heap.add(new Pair<Integer,Integer>(countSoldiers(mat[i]), i));
            if (max_heap.size() > k)
            {
                max_heap.poll();
            }
        }

        int[] result = new int[k];
        int i = k-1;
        while (max_heap.size() > 0)
        {
            result[i] = max_heap.peek().getValue();
            max_heap.poll();
            i--;
        }
        return result;
    }
}
