package HashMap;
import java.util.Map;
import java.util.HashMap;

public class Max_Number_of_K_Sum_Pairs_1679 {
    public static void main(String[] args) {
        
    }

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(k - nums[i]))
            {
                count++;
                if (map.get(k - nums[i]) == 1)
                {
                    map.remove(k - nums[i]);
                }
                else
                {
                    map.put(k - nums[i], map.get(k - nums[i]) - 1);
                }
            }
            else
            {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        return count;
    }
}
