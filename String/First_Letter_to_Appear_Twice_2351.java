package String;

public class First_Letter_to_Appear_Twice_2351 {
    public char repeatedCharacter(String s) {
        int n = s.length();
        int[] hash = new int[26];
        for (int i = 0; i < n; i++)
        {
            int index = s.charAt(i) - 'a';
            hash[index]++;
            if (hash[index] > 1)
            {
                return s.charAt(i);
            }
        }
        return s.charAt(n-1);
    }
}
