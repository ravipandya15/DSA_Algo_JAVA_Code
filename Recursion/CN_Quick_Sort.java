package Recursion;

import java.util.Collections;
import java.util.List;

public class CN_Quick_Sort {
    
    private static int partition(List<Integer> arr, int s, int e)
    {
        int pivot = arr.get(s);

        //count no. of element which are smaller than or equal to s;
        int count = 0;
        for (int index = s + 1; index <= e; index++)
        {
            if (arr.get(index) <= pivot) count++;
        }

        //find proper index;
        int pivotIndex = s + count;

        // swap
        Collections.swap(arr, pivotIndex, s);

        int i = s, j = e;
        while (i < pivotIndex && j > pivotIndex)
        {
            while (arr.get(i) <= pivot) i++;
            while (arr.get(j) > pivot) j--;

            if (i < pivotIndex && j > pivotIndex)
            {
                // swap
                Collections.swap(arr, i, j);
                i++;
                j--;
            }
        }

        return pivotIndex;
    }

    private static void solve(List<Integer> arr, int s, int e)
    {
        if (s >= e) return;

        //do partition
        int p = partition(arr, s, e);

        // Sort left part
        solve(arr, s, p - 1);

        // Sort right part
        solve(arr, p+1, e - 1);
    }

    public static List<Integer> quickSort(List<Integer> arr)
    {
        solve(arr, 0, arr.size() - 1);
        return arr;
    }

}
