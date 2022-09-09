package Array;

import java.util.ArrayList;
import java.util.List;

public class Plus_One_66 {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if (digits[n-1] + 1 < 10)
        {
            digits[n-1]++;
            return digits;
        }
        List<Integer> list = new ArrayList<>();
        int carry = 1; // as digits[n-1] + 1 < 10 is false
        int data = 0;
        for (int i = n-1; i >= 0; i--)
        {
            data = digits[i] + carry;
            carry = data / 10;
            data = data % 10;
            list.add(0, data);
        }
        if (carry > 0)
        {
            list.add(0, carry);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

    public int[] plusOne_1(int[] digits) {
        int n = digits.length;
        if (digits[n-1] + 1 < 10)
        {
            digits[n-1]++;
            return digits;
        }
        List<Integer> list = new ArrayList<>();
        int carry = 0;
        int data = digits[n-1] + 1;
        carry = data / 10;
        data = data % 10;
        list.add(0, data);
        //int i = n-2;
        for (int i = n-2; i >= 0; i--)
        {
            data = digits[i] + carry;
            carry = data / 10;
            data = data % 10;
            list.add(0, data);
        }
        if (carry > 0)
        {
        list.add(0, carry);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}
