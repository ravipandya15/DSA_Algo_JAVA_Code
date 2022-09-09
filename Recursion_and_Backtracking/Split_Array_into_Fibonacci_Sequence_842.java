package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Split_Array_into_Fibonacci_Sequence_842 {

    // working
    public static boolean solve(int index, int[] count, int[] size, String num, List<Integer> ans, int n)
    {
        if (index == n)
        {
            if (count[0] == n-1 && size[0] >= 3) return true;
            return false;
        }

        int data = 0;
        for (int i = index; i < n; i++)
        {
            data = data * 10 + (num.charAt(i) - '0');
            if (size[0] < 2 || data == ans.get(size[0]-1) + ans.get(size[0]-2))
            {
                ans.add(data);
                size[0]++;
                count[0] = i;
                if (solve(i + 1, count, size, num, ans, n)) return true;
                ans.remove(size[0] - 1);
                size[0]--;
                if (data == 0) return false;
            }
            else if (data > ans.get(size[0]-1) + ans.get(size[0]-2))
            {
                return false;
            }
            else if (data == 0)
            {
                return false;
            }
        }
        
        return false;
    }
    
    public List<Integer> splitIntoFibonacci(String num) {
        int n = num.length();
        int[] count = {0};
        int[] size = {0};
        List<Integer> ans = new ArrayList<>();
        if (solve(0, count, size, num, ans, n))
        {
            if (count[0] == n-1 && size[0] >= 3) return ans;
        }
        return new ArrayList<Integer>();
    }
}
