package String;

import java.util.Arrays;

public class Smallest_Value_of_the_Rearranged_Number_2165 {


    private static void reverse(char[] ch)
    {
        int i = 0;
        int j = ch.length - 1;
        while (i <= j)
        {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }

    public long smallestNumber(long num) {
        char[] str = String.valueOf(Math.abs(num)).toCharArray();
        Arrays.sort(str);
        if (num < 0)
        {
            reverse(str);
        }

        if (num > 0)
        {
            int index = 0;
            for (int i = 0; i < str.length; i++)
            {
                if (str[i] != '0')
                {
                    index = i;
                    break;
                }
            }
            char temp = str[0];
            str[0] = str[index];
            str[index] = temp;
        }

        long ans = Long.parseLong(new String(str));
        if (num < 0) 
        {
            ans = ans * -1;
        }

        return ans;
    }
}
