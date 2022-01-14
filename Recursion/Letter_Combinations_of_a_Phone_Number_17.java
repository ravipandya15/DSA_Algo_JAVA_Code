package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number_17 {
    
    private static void solve(String digits, int index, StringBuilder output, 
                                  String[] mapping, List<String> result)
    {
        if (index == digits.length())
        {
            result.add(new String(output.toString()));
            return;
        }

        int number = digits.charAt(index) - '0';
        String value = mapping[number];

        for (int i = 0; i < value.length(); i++)
        {
            output.append(value.charAt(i));
            solve(digits, index + 1, output, mapping, result);
            output.deleteCharAt(output.length()-1); // knows as back-tracking
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();

        if (digits.length() == 0) return result;
        StringBuilder output = new StringBuilder();
        String[] mapping = new String[] { "", "", "abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        solve(digits, 0, output, mapping, result);
        return result;
    }

}
