package Divide_and_conquer;

public class Longest_Substring_with_At_Least_K_Repeating_Characters_395 {

    public static int solve(String s, int start, int end, int k)
    {
        if (start > end) return 0;
        if (end - start + 1 < k) return 0;
        int j = start;
        int[] map = new int[26];
        for (int i = start; i <= end; i++)
        {
            map[s.charAt(i) - 'a']++;
        }
        while (j <= end && map[s.charAt(j) - 'a'] >= k) j++;
        if (j == end + 1) return end - start + 1;

        int left = solve(s, start, j - 1, k);
        int right = solve(s, j + 1, end, k);
        return Math.max(left, right);
    }

    public int longestSubstring(String s, int k) {
        return solve(s, 0, s.length() - 1, k);
    }
}
