package Recursion;

public class Valid_Palindrome_125 {
    
    public static char ConvertToLower(char ch)
    {
        if ((ch >= 'a' && ch <= 'z') || ch >= '0' && ch <= '9')
            return ch;
        else
        {
            return (char)(ch - 'A' + 'a');
        }
    }

    public static boolean Check(char ch)
    {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))
            return true;
        else
            return false;
    }

    public boolean isPalindrome(String str) {
        int s = 0;
        int n = str.length() - 1;
        int e = n;

        while (s <= e)
        {
            while (s <= n && (str.charAt(s) < 'a' || str.charAt(s) > 'z') &&
                (str.charAt(s) < 'A' || str.charAt(s) > 'Z') &&
                (str.charAt(s) < '0' || str.charAt(s) > '9'))
            {
                s++;
            }
            while (e >= 0 && (str.charAt(e) < 'a' || str.charAt(e) > 'z') &&
                (str.charAt(e) < 'A' || str.charAt(e) > 'Z') &&
                (str.charAt(e) < '0' || str.charAt(e) > '9'))
            {
                e--;
            }

            //if ((s > n) || e < 0)
            //    return true;
            if ((s > n) || (e < 0))
                break;

            if (ConvertToLower(str.charAt(s)) != ConvertToLower(str.charAt(e)))
            {
                return false;
            }
            else
            {
                s++;
                e--;
            }
        }

        return true;
    }

}
