package Greedy;

public class Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K_1414 {
    public int findMinFibonacciNumbers(int k) {
        // base case
        //if (k == 0) return 0;
        if (k < 2) return k;
        int a = 1, b = 1;
        while (b <= k)
        {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return 1 + findMinFibonacciNumbers(k - a);
    }
}
