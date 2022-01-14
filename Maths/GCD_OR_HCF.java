package Maths;

public class GCD_OR_HCF {
    public static void main(String[] args) {
        System.out.println("GCD_OR_HCF.java");
        int a = 24, b = 72;
        System.out.println("GCD of " + a + " and " +  b + " is " + GCD(a,b));

    }

    public static int GCD(int a, int b)
        {
            if (a == 0) return b;
            if (b == 0) return a;

            while (a != b)
            {
                if (a > b) a = a - b;
                else b = b - a;
            }
            return a;
        }
}
