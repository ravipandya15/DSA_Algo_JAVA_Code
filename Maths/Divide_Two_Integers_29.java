package Maths;

public class Divide_Two_Integers_29 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        boolean isNegative = false;
        if (dividend < 0 && divisor < 0)
        {
            dividend *= -1;
            divisor *= -1;
        }
        else if (dividend < 0)
        {
            isNegative = true;
            dividend *= -1;
        }
        else if (divisor < 0)
        {
            isNegative = true;
            divisor *= -1;
        }
        
        long count = 0;
        long sum = 0;
        while (sum + divisor <= dividend)
        {
            if (sum + divisor > Integer.MAX_VALUE) break;
            if (isNegative && (-1 * (sum + divisor)) < Integer.MIN_VALUE) break;
            count++;
            sum = sum + divisor;
        }
        
        if (isNegative)
        {
            count *= -1;
        }
        if (count > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (count < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)count;
    }
}
