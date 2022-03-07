package String;

public class Is_Subsequence_392 {
    
    //Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    //A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) 
    //of the characters without disturbing the relative positions of the remaining characters. 
    //(i.e., "ace" is a subsequence of "abcde" while "aec" is not).
    
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int i = 0;
        for (int j = 0; j < t.length(); j++)
        {
            if (s.charAt(i) == t.charAt(j))
            {
                i++;
            }
            
            if (i == s.length())
            {
                return true;
            }
        }
        
        return false;
    }
}
