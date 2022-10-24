package PrefixSum;

import java.util.ArrayList;
import java.util.List;

public class Can_Make_Palindrome_from_Substring_1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        int n = s.length();
        int[][] prefixSum = new int[n+1][26];
        for (int i = 1; i <= n; i++)
        {
            prefixSum[i][s.charAt(i-1) - 'a']++;
            for (int j = 0; j < 26; j++)
            {
                prefixSum[i][j] += prefixSum[i-1][j];
            }
        }

        for (int i = 0; i < queries.length; i++)
        {
            int left = queries[i][0];
            int right = queries[i][1];
            int operations = queries[i][2];

            int odd = 0;
            for (int j = 0; j < 26; j++)
            {
                int count = prefixSum[right+1][j] - prefixSum[left][j];
                if (count % 2 != 0) odd++;
            }
            
            odd = odd - 2 * operations;
            if (odd > 1) ans.add(false);
            else ans.add(true);
        }
        return ans;
    }
}
