package Dynamic_Programming_Series;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses_22 {

    // NOT working


    public static List<String> solve(int n)
    {
        List<String> result = new ArrayList<>();
        if (n == 1)
        {
            result.add("()");
            return result;
        }

        List<String> list = solve(n-1);
        int k = list.size();
        for (int i = 0; i < k; i++)
        {
            String s = list.get(i);
            result.add("(" + s + ")");
            //result.add(s + "()");
            //if (i < k - 1) result.add("()" + s);
        }
        for (int i = 0; i < k; i++)
        {
            String s = list.get(i);
            result.add(s + "()");
            if (i < k - 1) result.add("()" + s);
        }
        // for (int i = 0; i < k; i++)
        // {
        //     String s = list.get(i);
        //     //result.add(s + "()");
        //     if (i < k - 1) result.add("()" + s);
        // }
        return result;
    }
    public List<String> generateParenthesis(int n) {
        return solve(n);
    }
}
