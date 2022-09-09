package String;

public class String_to_Integer_atoi_8 {
    
    public int myAtoi(String s) {
        if (s == null) return 0;
        int n = s.length();
        if (n == 0) return 0;
        
        int i = 0;

        s = s.trim();

        //s = s.substring(i); -> NOT REQUIRE

        if (s.length() == 0) return 0;
        int sign = +1;
        long ans = 0;

        if (s.charAt(0) == '-') sign = -1;

        int maxi = Integer.MAX_VALUE;
        int mini = Integer.MIN_VALUE;
        i = (s.charAt(0) == '-' || s.charAt(0) == '+') ? 1 : 0;
        

        while (i < s.length())
        {
            if (s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i))) break;
            ans = ans * 10 + (s.charAt(i) - '0');

            if (sign == -1 && -1 * ans < mini) return mini;
            if (sign == 1 && ans > maxi) return maxi;

            i++;
        }

        return (int)(sign * ans);
    }
}
