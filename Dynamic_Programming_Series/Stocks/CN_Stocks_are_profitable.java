package Dynamic_Programming_Series.Stocks;

import java.util.ArrayList;

public class CN_Stocks_are_profitable {
    
    public static int maximumProfit(ArrayList<Integer> prices){
        int mini = prices.get(0);
        int profit = 0;
        for (int i = 1; i < prices.size(); i++)
        {
            int currentProfit = prices.get(i) - mini;
            profit = Math.max(profit, currentProfit);
            mini = Math.min(mini, prices.get(i));
        }

        return profit;
    }
}
