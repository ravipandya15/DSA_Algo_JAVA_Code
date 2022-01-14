package Recursion;

public class Pow_of_x_to_n_50 {
    


    //Prefered way is Iterative



    private static double Recursion(double x, int n)
    {
        if (n == 0) return 1;
        if (n == 1) return x;

        // Recursive call
        double ans = Recursion(x, n/2);
        if ((n & 1) == 0)
        {//even
            return ans * ans;
        }
        else
        {//odd
            return x * ans * ans;
        }
    }

    public double myPow(double x, int n) {
        if (n < 0)
        {
            double ans = Recursion(x, -n);
            return (double)(1.0) / (double)(ans);

        }
        else
        {
            return Recursion(x, n);
        }  
    }


    public double myPow_Iterative(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if (nn < 0)
            nn = -1 * nn;

        while(nn > 0)
        {
            if (nn % 2 == 1)
            {
                ans = ans * x;
                nn = nn - 1;
            }
            else
            {
                x = x * x;
                nn = nn / 2;
            }
        }

        if (n < 0)
        {
            ans = (double)(1.0) / (double)ans;
        }
        return ans;
    }

}
