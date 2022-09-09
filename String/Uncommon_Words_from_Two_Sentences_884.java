package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Uncommon_Words_from_Two_Sentences_884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        int s = 0, e = 0;
        for (e = 1; e < s1.length(); e++)
        {
            if (s1.charAt(e) == ' ')
            {
                map.put(s1.substring(s, e), map.getOrDefault(s1.substring(s, e), 0) + 1);
                s = e + 1;
                e++;
            }
        }
        map.put(s1.substring(s, e), map.getOrDefault(s1.substring(s, e), 0) + 1);
        s = 0;
        e = 0;
        for (e = 1; e < s2.length(); e++)
        {
            if (s2.charAt(e) == ' ')
            {
                map.put(s2.substring(s, e), map.getOrDefault(s2.substring(s, e), 0) + 1);
                s = e + 1;
                e++;
            }
        }
        map.put(s2.substring(s, e), map.getOrDefault(s2.substring(s, e), 0) + 1);
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) 
        {
            if (entry.getValue() == 1)
            {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }
}
