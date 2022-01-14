package Recursion;

public class Say_Digit {
    
    // Normal question from Cpdehelp -> Love bubber -> Lecture 32 -> Recursion
    // string[] contains {"One", "Two", "Three", .........., "Nine"}
    void sayDigit(int n, String[] arr)
    {
        if (n == 0) return;
        int digit = n % 10;
        n /= 10;
        sayDigit(n, arr);
        System.out.println(arr[digit] + " ");
    }

}
