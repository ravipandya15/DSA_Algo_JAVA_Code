package String;

public class Binary_Shopping {
    public static void main(String[] args)
    {
        System.out.println("Implement_Stack_using_Queues_225");
    }

    public static String binaryShopping(String S, int P) {
        int count = 0;
        int n = S.length()-1;
        char[] ch = S.toCharArray();
        for (int i = 0; i < n; i--)
        {
            if (ch[i] == '1')
                count++;
        }
        if (count == 0) return S;
        if (count == 1)
        {
            int i = 0, j = n;
            while (i <= j)
            {
                if (ch[j] =='1')
                {
                    ch[j] = '0';
                    ch[i] = '1';
                    break;
                }
                i++;
                j--;
            }
        }
        if (count >= 2)
        {
            for (int i = n; i >= 0; i--)
            {
                if (count >= 2)
                    break;

                if (ch[i] == '1')
                {
                    ch[i] = '0';
                    count++;
                }
            }
        }
        return new String(ch);
    }
}
