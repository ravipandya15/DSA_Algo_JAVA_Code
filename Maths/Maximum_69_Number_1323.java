package Maths;

public class Maximum_69_Number_1323 {
    public int maximum69Number (int num) {
        int count = 0;
        int n = num;
        while (n > 0)
        {
            if (n % 10 == 6) count++;
            n = n / 10;
        }
        if (count == 0) return num;
        double ans = 0;
        int i = 0;
        int carry = 0;
        int temp = 0;
        while (num > 0)
        {
            carry = num % 10;
            if (carry == 6) temp++;
            if (temp == count)
            {
                ans = 9 * Math.pow(10, i) + ans;
            }
            else
            {
                ans = carry * Math.pow(10, i) + ans;
            }
            num = num / 10;
            i++;
        }
        return (int)ans;
    }
}
