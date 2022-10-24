package Greedy;

import java.util.Arrays;

public class Maximum_Ice_Cream_Bars_1833 {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int ans = 0;
        Arrays.sort(costs);
        for (int i = 0; i < n; i++)
        {
            if (costs[i] <= coins)
            {
                ans++;
                coins -= costs[i];
            }
            else break;
        }
        return ans;
    }
}
