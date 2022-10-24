package Dynamic_Programming_Series;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses_22 {


    public void solve(int openN, int closeN, int n, List<String> list, StringBuilder sb)
    {
        // base case
        if (openN == n && closeN == n)
        {
            //list.add(sb.toString()); ---> this will also work
            list.add(new String(sb.toString()));
            return;
        }

        // add open
        if (openN < n)
        {
            int len = sb.length();
            sb.append("(");
            solve(openN + 1, closeN, n, list, sb);
            sb.setLength(len);
        }

        // add close
        if (closeN < openN)
        {
            int len = sb.length();
            sb.append(")");
            solve(openN, closeN + 1, n, list, sb);
            sb.setLength(len);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(0, 0, n, list, sb);
        return list;
    }
}
