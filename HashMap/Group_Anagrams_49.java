package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs)
        {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedString = new String(arr);

            if (map.containsKey(sortedString))
            {
                map.get(sortedString).add(str);
            }
            else
            {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                map.put(sortedString, stringList);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet())
        {
            list.add(entry.getValue());
        }
        return list;
    }
}
