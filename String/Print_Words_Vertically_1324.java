package String;

import java.util.ArrayList;
import java.util.List;

public class Print_Words_Vertically_1324 {
    public List<String> printVertically(String s) {
        String[] arr = s.split(" ");
        int length = arr[0].length();
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            length = Math.max(length, arr[i].length());
        }
        List<String> ans = new ArrayList<String>(length);
        for (int i = 0; i < length; i++)
        {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++)
            {
                if (i < arr[j].length())
                {
                    sb.append(arr[j].charAt(i));
                }
                else
                {
                    sb.append(' ');
                }
            }
            int count = sb.length() - 1;
            while (count > 0)
            {
                if (sb.charAt(count) == ' ')
                {
                    count--;
                }
                else
                {
                    break;
                }
            }
            ans.add(sb.toString().substring(0, count + 1));
        }
        return ans;
    }
}
