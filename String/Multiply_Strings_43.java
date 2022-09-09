package String;

public class Multiply_Strings_43 {
    public static String add(String s1, String s2)
    {
        StringBuilder sb = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        long data = 0;
        long carry = 0;
        while (i >= 0 || j >= 0)
        {
            data = carry;
            if (i >= 0) data += (s1.charAt(i) - '0');
            if (j >= 0) data += (s2.charAt(j) - '0');
            carry = data / 10;
            data = data % 10;
            sb.insert(0, data);
            i--;
            j--;
        }
        if (carry > 0) sb.insert(0, carry);
        return sb.toString();
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int i = 0;
        int j = num2.length() - 1;
        String result = "";
        int multiply = 0;
        while (j >= 0)
        {
            StringBuilder sb = new StringBuilder();
            i = num1.length() - 1;
            int data = 0, carry = 0;
            while (i >= 0)
            {
                data = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;
                carry = data / 10;
                data = data % 10;
                sb.insert(0, data);
                i--;
            }
            if (carry > 0)
            {
                sb.insert(0, carry);
            }
            int m = multiply;
            while (multiply > 0)
            {
                sb.append(0);
                multiply--;
            }
            multiply = m;
            result = add(result, sb.toString());
            multiply++;
            j--;
        }
        return result;
    }

    public static String add_1(String s1, String s2)
    {
        StringBuilder sb = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        long data = 0;
        long carry = 0;
        while (i >= 0 || j >= 0)
        {
            data = carry;
            if (i >= 0) data += (s1.charAt(i) - '0');
            if (j >= 0) data += (s2.charAt(j) - '0');
            carry = data / 10;
            data = data % 10;
            sb.append(data);
            i--;
            j--;
        }
        if (carry > 0) sb.append(carry);
        sb = sb.reverse();
        return sb.toString();
    }

    public String multiply_1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int i = 0;
        int j = num2.length() - 1;
        String result = "";
        int multiply = 0;
        while (j >= 0)
        {
            StringBuilder sb = new StringBuilder();
            i = num1.length() - 1;
            int data = 0, carry = 0;
            while (i >= 0)
            {
                data = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;
                carry = data / 10;
                data = data % 10;
                sb.append(data);
                i--;
            }
            if (carry > 0)
            {
                sb.append(carry);
            }
            sb = sb.reverse();
            int m = multiply;
            while (multiply > 0)
            {
                sb.append(0);
                multiply--;
            }
            multiply = m;
            result = add_1(result, sb.toString());
            multiply++;
            j--;
        }
        return result;
    }
}
