package Queue.Love_bubber_Queue;

import java.util.Deque;
import java.util.LinkedList;

public class GFG_Sum_of_Minimum_and_Maximum_of_all_SubArrays_of_Size_K {
    
    public static void main(String[] args) {
        int[] arr = new int[] {2, 5, -1, 7, -3, -1, -2};
        int k = 4;

        int ans = sumOfKSubArray(arr, k);
        System.out.println(ans);
    }

    public static int sumOfKSubArray(int[] arr, int k)
    {
        int n = arr.length;
        Deque<Integer> maxi = new LinkedList<Integer>(); // -> store value in decreasing order
        Deque<Integer> mini = new LinkedList<Integer>(); // -> store value in increasing order

        // process 1st window of size k
        for (int i = 0; i < k; i++)
        {
            while (!maxi.isEmpty() && arr[maxi.peekLast()] <= arr[i])
                maxi.removeLast();

            while (!mini.isEmpty() && arr[mini.peekLast()] >= arr[i])
                mini.removeLast();
            
            maxi.addLast(i);
            mini.addLast(i);
        }

        int ans = arr[maxi.peekFirst()] + arr[mini.peekFirst()];

        // process for remaining elements
        for (int i = k; i < n; i++)
        {
            // remove out of index elements (indexs)
            while (!maxi.isEmpty() && i - maxi.peekFirst() >= k)
                maxi.removeFirst();
            
            while (!mini.isEmpty() && i - mini.peekFirst() >= k)
                mini.removeFirst();

            while (!maxi.isEmpty() && arr[maxi.peekLast()] <= arr[i])
                maxi.removeLast();

            while (!mini.isEmpty() && arr[mini.peekLast()] >= arr[i])
                mini.removeLast();
            
            maxi.addLast(i);
            mini.addLast(i);

            ans += arr[maxi.peekFirst()] + arr[mini.peekFirst()];
        }

        return ans;
    }
}
