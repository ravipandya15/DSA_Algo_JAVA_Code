package String;

public class Zigzag_Conversion_6 {

    public String convert(String s, int numRows) {

        // base case 
        if (numRows == 1) return s;
        int n = s.length();
        String res = "";

        for (int r = 0; r < numRows; r++)
        {
            int jumps = 2 * (numRows - 1);
            // jumps
            for (int i = r; i < n; i = i + jumps)
            {
                res += s.charAt(i);
                if (r > 0 && r < numRows - 1 && i + jumps - (2 * r) < n) // not first and last rows
                {
                    res += s.charAt(i + jumps - (2 * r));
                }
            }
        }

        return res;
    }

    public String convert_1(String s, int numRows) {

        // base case 
        if (numRows == 1) return s;
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < numRows; r++)
        {
            int jumps = 2 * (numRows - 1);
            // jumps
            for (int i = r; i < n; i = i + jumps)
            {
                sb.append(s.charAt(i));
                if (r > 0 && r < numRows - 1 && i + jumps - (2 * r) < n) // not first and last rows
                {
                    sb.append(s.charAt(i + jumps - (2 * r)));
                }
            }
        }

        return sb.toString();
    }
}
