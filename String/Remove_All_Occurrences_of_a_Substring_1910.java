package String;

public class Remove_All_Occurrences_of_a_Substring_1910 {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part))
        {
            s = s.replaceFirst(part, "");
        }
        return s;
    }    
}
