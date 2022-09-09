package String;

public class Add_Strings_415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int data = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0)
        {
            data = carry;
            if (i >= 0) data += num1.charAt(i) - '0';
            if (j >= 0) data += num2.charAt(j) - '0';
            carry = data / 10;
            data = data % 10;
            sb.insert(0, data);
            i--;
            j--;
        }
        if (carry > 0)
        {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
