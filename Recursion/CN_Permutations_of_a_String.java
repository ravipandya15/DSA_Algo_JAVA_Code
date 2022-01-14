package Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class CN_Permutations_of_a_String {
    
    private static void Swap(int i, int j, StringBuilder str)
    {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }

    private static void Solve(int index, StringBuilder output, ArrayList<String> result)
    {
        // base case
        if (index == output.length())
        {
            result.add(new String(output));
            return;
        }


        for (int i = index; i < output.length(); i++)
        {
            Swap(index, i, output);
            Solve(index + 1, output, result);
            Swap(index, i, output);
        }
    }

    public static ArrayList<String> generatePermutations(String str) {
		ArrayList<String> result = new ArrayList<String>();
        StringBuilder output = new StringBuilder(str);
        Solve(0, output, result);
        Collections.sort(result);
        return result;
	}
    
}
