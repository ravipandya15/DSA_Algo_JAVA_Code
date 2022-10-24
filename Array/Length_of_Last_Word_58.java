package Array;

public class Length_of_Last_Word_58 {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int i = n - 1;

        // ignore spaces
        while (i >= 0 && s.charAt(i) == ' ')
        {
            i--;
        }
        int last = i;
        while (i >= 0 && s.charAt(i) != ' ')
        {
            i--;
        }
        return last - i;
    }
}
