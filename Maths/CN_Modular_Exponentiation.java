package Maths;

public class CN_Modular_Exponentiation {
    public static void main(String[] args)
    {
        System.out.println("CN) Modular Exponentiation");
    }

    // not 100 % submitted
    public static int modularExponentiation(int x, int n, int m) {
        int result = 1;

        while (n > 0)
        {
            if ((n & 1) == 1)
            {// odd
                result = (int)((Long.valueOf((result) % m * (x) % m)) % m);
            }
            x = (int)((Long.valueOf((x) % m * (x) % m)) % m);
            n = n >> 1; // divide by 2
        }
        return result;      
    }


}
