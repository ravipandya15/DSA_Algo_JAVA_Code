package String;

import java.util.HashMap;
import java.util.Map;

public class Count_Common_Words_With_One_Occurrence_2085 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int count = 0;
        for (String s : words1)
        {
           map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (String s : words2)
        {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map1.entrySet())
        {
            if (map2.containsKey(entry.getKey()) && entry.getValue() == 1 && map2.get(entry.getKey()) == 1)
            {
                count++;
            }
        }
        return count;
    }
}
