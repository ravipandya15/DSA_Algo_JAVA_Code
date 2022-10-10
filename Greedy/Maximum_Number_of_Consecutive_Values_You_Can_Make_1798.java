package Greedy;

import java.util.Arrays;

public class Maximum_Number_of_Consecutive_Values_You_Can_Make_1798 {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int ans = 0;
        for (int coin : coins)
        {
            if (coin > ans + 1) return ans + 1;
            ans += coin;
        }
        return ans + 1;
    }
}
