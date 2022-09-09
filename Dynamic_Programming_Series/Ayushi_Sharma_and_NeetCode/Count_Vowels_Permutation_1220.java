package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

public class Count_Vowels_Permutation_1220 {
    public long[] solve(int index, int mod)
    {
        if (index == 1)
        {
            return new long[] {1, 1, 1, 1, 1};
        }
        long[] prev = solve(index-1, mod);

        long[] ans = new long[5];

        ans[0] = prev[1] % mod;
        ans[1] = (prev[0] + prev[2]) % mod;
        ans[2] = (prev[0] + prev[1] + prev[3] + prev[4]) % mod;
        ans[3] = (prev[2] + prev[4]) % mod;
        ans[4] = (prev[0]) % mod;

        return ans;
    }

    public int countVowelPermutation(int n) {
        int mod = (int)1e9 + 7;
        long[] ans = solve(n, mod);
        long count = 0;
        for (int i = 0; i < 5; i++)
        {
            count = (count + ans[i]) % mod;
        }
        return (int)count % mod;
    }

    public int countVowelPermutation_1(int n) {
        int mod = (int)1e9 + 7;
        long[] prev = {1, 1, 1, 1, 1};
        long count = 0;

        for (int j = 1; j < n; j++)
        {
            long[] ans = new long[5];
            ans[0] = prev[1] % mod;
            ans[1] = (prev[0] + prev[2]) % mod;
            ans[2] = (prev[0] + prev[1] + prev[3] + prev[4]) % mod;
            ans[3] = (prev[2] + prev[4]) % mod;
            ans[4] = (prev[0]) % mod;

            prev = ans;
        }

        for (int i = 0; i < 5; i++)
        {
            count = (count + prev[i]) % mod;
        }
        return (int)count % mod;
    }
}
