package String;

import java.util.ArrayList;
import java.util.List;

public class Add_to_Array_Form_of_Integer_989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int data = 0, carry = 0;
        List<Integer> ans = new ArrayList<>();
        //for (int i = num.length - 1; i >= 0; i--)
        int i = num.length - 1;
        while (i >= 0 || k > 0)
        {
            data = carry;
            if (i >= 0) data += num[i];
            if (k > 0)
            {
                data += k % 10;
                k = k / 10;
            }
            if (data >= 10)
            {
                carry = data / 10;
                data = data % 10;   
            }
            else
            {
                carry = 0;
            }
            ans.add(0, data);
            i--;
        }
        if (carry > 0)
        {
            ans.add(0, carry);
        }
        return ans;
    }
}
