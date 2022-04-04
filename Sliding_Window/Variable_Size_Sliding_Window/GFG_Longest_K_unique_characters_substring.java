package Sliding_Window.Variable_Size_Sliding_Window;

import java.util.HashMap;

public class GFG_Longest_K_unique_characters_substring {
    
    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();

        int i = 0, j = 0;
        int maxi = -1;
        int n = s.length();

        while (j < n)
        {
            // calculation
            if (mp.containsKey(s.charAt(j)))
            {
                mp.put( s.charAt(j), mp.get(s.charAt(j)) + 1 );
            }
            else
            {
                mp.put(s.charAt(j), 1);
            }

            if (mp.size() < k)
            {
                j++;
            }
            else if (mp.size() == k)
            {
                // ans
                maxi = Math.max(maxi, j - i + 1);
                j++;
            }
            else if (mp.size() > k)
            {
                while (mp.size() > k)
                {
                    mp.put( s.charAt(i), mp.get(s.charAt(i)) - 1 );
                    if (mp.get(s.charAt(i)) == 0)
                    {
                        mp.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }

        return maxi;
    }
}
