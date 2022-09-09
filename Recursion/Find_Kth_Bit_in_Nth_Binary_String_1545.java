package Recursion;

public class Find_Kth_Bit_in_Nth_Binary_String_1545 {

    public static StringBuilder invert(StringBuilder str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '0')
            {
                str.setCharAt(i, '1');
            }
            else
            {
                str.setCharAt(i, '0');
            }
        }
        return str;
    }

    public static String reverse(StringBuilder str)
    {
        int l = 0, r = str.length()-1;
        while (l < r)
        {
            char ch = str.charAt(l);
            str.setCharAt(l, str.charAt(r));
            str.setCharAt(r, ch);
            l++;
            r--;
        }
        return str.toString();
    }

    public static StringBuilder solve(int n)
    {
        // base case
        if (n == 0) return new StringBuilder("0");

        StringBuilder prev = solve(n-1);
        String reversed = reverse(invert(prev));
        prev.append("1").append(reversed);
        return prev;
    }
    
    public char findKthBit(int n, int k) {
        StringBuilder str =  solve(n);
        return str.charAt(k-1);
    }
}
