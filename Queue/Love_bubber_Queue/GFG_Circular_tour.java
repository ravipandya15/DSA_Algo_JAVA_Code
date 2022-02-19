package Queue.Love_bubber_Queue;

public class GFG_Circular_tour {
    
    public int tour(int petrol[], int distance[])
    {
        int n = petrol.length;
        int start = 0;
        int deficit = 0;
        int balance = 0;

        for (int i = 0; i < n; i++)
        {
            balance = balance + petrol[i] - distance[i];
            if (balance < 0)
            {
                deficit = deficit + balance;
                start = i + 1;
                balance = 0;
            }
        }

        if (deficit + balance >= 0)
        {
            return start;
        }
        return -1;
    }
}
