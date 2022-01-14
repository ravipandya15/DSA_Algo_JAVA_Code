package Recursion;

import java.util.ArrayList;

public class CN_Subsequences_of_String {
    
    private static void solve(String str, int index, StringBuilder output, ArrayList<String> ans)
    {
        // base case
        if (index >= str.length())
        {
            if (output.length() > 0)
            {
                ans.add(new String(output.toString()));
            }
            return;
        }

        // exclude
        solve(str, index + 1, output, ans);

        // inclde
        output.append(str.charAt(index));
        solve(str, index + 1, output, ans);
        output.deleteCharAt(output.length() - 1);
    }

    public static ArrayList<String> subsequences(String str) {
        ArrayList<String> ans = new ArrayList<String>();
        String s = "";
        StringBuilder output = new StringBuilder(s);
        solve(str, 0, output, ans);
        return ans;
    }
    
}
