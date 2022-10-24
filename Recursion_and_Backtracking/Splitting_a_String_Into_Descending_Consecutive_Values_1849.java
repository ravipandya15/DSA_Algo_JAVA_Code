package Recursion_and_Backtracking;

public class Splitting_a_String_Into_Descending_Consecutive_Values_1849 {

    public static boolean solve(int start, String s, long prev, int[] count, int n, boolean flag)
    {
        // base case
        if (start > n) return false;
        if (start == n)
        {
            if (flag == false) return false;
            return count[0] >= 2;
        }

        if (s.charAt(start) == '0' && prev != 1)
        {
            return solve(start + 1, s, prev, count, n, false);
        }
        for (int end = start + 1; end <= n; end++)
        {
            if (end - start > 10) return false;
            long value = Long.parseLong(s.substring(start, end));
            if (prev == -1 || value == prev - 1)
            {
                count[0]++;
                long temp = prev;
                prev = value;
                if (solve(end, s, prev, count, n, true)) return true;
                prev = temp;
                count[0]--;
            }
        }
        return false;
    }

    public boolean splitString(String s) {
        int n = s.length();
        int[] count = {0};
        boolean flag = true;
        return solve(0, s, -1, count, n, true);
    }
}
