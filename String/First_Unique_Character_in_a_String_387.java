package String;

public class First_Unique_Character_in_a_String_387 {
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] hash = new int[26];
        for (int i = 0; i < n; i++)
        {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++)
        {
            if (hash[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
