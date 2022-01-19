package LinkedList.DoublyLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class Sliding_Window_Maximum_239 {
    public static void main(String[] args) {
        System.out.println("239. Sliding_Window_Maximum");
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        var result = MaxSlidingWindow(arr, k);
        System.out.println(result);
    }

    // TC -> O(N) + O(N) = O(N)
    // SC -> O(K) -> at max deque will store k element
    public static int[] MaxSlidingWindow(int[] nums, int k)
    {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int ri = 0;

        for (int i = 0; i < n; i++)
        {
            while (!deque.isEmpty() && deque.peekFirst() == i - k)
                deque.pollFirst();

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();

            deque.addLast(i);

            if (i >= k - 1)
                ans[ri++] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
