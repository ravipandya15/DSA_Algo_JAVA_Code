package HashMap;
import java.util.Map;
import java.util.HashMap;
public class Longest_Consecutive_Sequence_128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int maxi = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int currentStreak = 0;
        int currentValue = 0;
        for (int num : nums)
        {
            if (!map.containsKey(num - 1))
            {
                
                currentStreak = 1;
                currentValue = num;
                while (map.containsKey(currentValue + 1))
                {
                    currentStreak++;
                    currentValue++;
                }
                maxi = Math.max(maxi, currentStreak);
            }
        }
        return maxi;
    }
}
