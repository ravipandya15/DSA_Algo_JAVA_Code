package String;

public class Excel_Sheet_Column_Title_168_GFG_Column_name_from_a_given_column_number {

    // TC -> O(LogN) + O(N) - for reverse string
    String colName (long n)
    {
        StringBuilder ans = new StringBuilder();
        while (n > 0)
        {
            long i = n % 26;
            if (i == 0)
            {
                ans.append((char)('A' + 25));
                n = (n / 26) - 1;
            }
            else
            {
                ans.append((char)('A' + i - 1));
                n = n / 26;
            }
        }
        return ans.reverse().toString();
    }

    String colName_1(long n)
    {
        StringBuilder ans = new StringBuilder();
        while (n > 0)
        {
            n--;
            ans.insert(0, (char)('A' + n % 26));
            n = n / 26;
        }
        return ans.toString();
    }
}
