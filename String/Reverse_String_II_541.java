package String;

public class Reverse_String_II_541 {
    public String reverseStr(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        int start = 0;
        int last = Math.min(start + 2 * k - 1, n-1);
        int end = 0;

        while (start < n)
        {
            end = start + k - 1;
            if (end >= n)
            {
                end = n-1;
            }
            while (start <= end)
            {
                char temp = sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, temp);
                start++;
                end--;
            }
            start = last + 1;
            last = Math.min(start + 2 * k - 1, n-1);
        }
        return sb.toString();
    }
}
