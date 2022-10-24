package String;

import java.util.List;

public class Longest_Word_in_Dictionary_through_Deleting_524 {

    public static boolean check(String s, String str)
    {
        int i = 0;
        int j = 0;
        int n = str.length();
        while (i < s.length() && j < n)
        {
            if (s.charAt(i) == str.charAt(j)) j++;
            i++;
        }
        return j == n;
    }

    // little bit faster compare to below one
    // TC -> O(K * N)
    public String findLongestWord_1(String s, List<String> dictionary) {
        String res = "";
        for (String str : dictionary)
        {
            if (str.length() > res.length() 
                   || (str.length() == res.length() && str.compareTo(res) < 0))
            {
                if (check(s, str)) res = str;
            }
        }
        return res;
    }

    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String str : dictionary)
        {
            if (str.length() >= res.length() && check(s, str))
            {
                if (str.length() > res.length() 
                   || (str.length() == res.length() && str.compareTo(res) < 0)) res = str;
            }
        }
        return res;
    }
}
