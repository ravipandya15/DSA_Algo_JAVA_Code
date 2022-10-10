package String;

public class Backspace_String_Compare_844 {

    public static String build(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length(), i = 0, j = 0;
        for (i = 0; i < n; i++)
        {
            if (j >= 0) sb.setCharAt(j, sb.charAt(i));
            if (sb.charAt(i) == '#')
            {
                j--;
                if (j < 0) j = 0;
            }
            else j++;
        }
        //System.out.println(sb.substring(0, j));
        return sb.substring(0, j);
    }
    
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
}
