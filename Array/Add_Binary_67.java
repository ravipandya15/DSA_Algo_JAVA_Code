package Array;

public class Add_Binary_67 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int data = 0;
        while (i >= 0 || j >= 0)
        {
            data = carry;
            if (i >= 0) data += (a.charAt(i) - '0');
            if (j >= 0) data += b.charAt(j) - '0';
            carry = data / 2;
            data = data % 2;
            sb.append(data);
            i--;
            j--;
        }
        if (carry > 0)
        {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
