package HashMap; 
import java.util.HashMap;

public class GFG_Largest_subarray_of_0s_and_1s {
    
    int maxLen(int[] arr, int N)
    {
        int sum = 0;
        int largest = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; i++)
        {
            sum = (arr[i] == 1) ? sum + arr[i] : sum + -1;

            if (sum == 0)
            {
                largest = i+1;
            }
            else
            {
                if (map.containsKey(sum))
                {
                    largest = Math.max(largest, i - map.get(sum));
                }
                else
                {
                    map.put(sum, i);
                }
            }
        }

        return largest;
    }
}
