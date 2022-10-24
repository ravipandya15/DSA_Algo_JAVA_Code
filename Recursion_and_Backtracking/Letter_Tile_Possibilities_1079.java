package Recursion_and_Backtracking;

public class Letter_Tile_Possibilities_1079 {
    public static int solve(int[] count)
    {
        int ans = 0;

        for (int i = 0; i < 26; i++)
        {
            if (count[i] > 0)
            {
                ans++;
                count[i]--;
                ans += solve(count);
                count[i]++;
            }
        }
        return ans;
    }
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (int i = 0; i < tiles.length(); i++)
        {
            count[tiles.charAt(i) - 'A']++;
        }
        return solve(count);
    }
}
