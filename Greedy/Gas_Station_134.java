package Greedy;

public class Gas_Station_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int balance = 0, start = 0, deficit = 0;

        for (int i = 0; i < n; i++)
        {
            balance += gas[i] - cost[i];
            if (balance < 0)
            {
                deficit = deficit + balance;
                start = i + 1;
                balance = 0;
            }
        }
        if (balance + deficit >= 0)
        {
            return start;
        }
        return -1;
    }
}
