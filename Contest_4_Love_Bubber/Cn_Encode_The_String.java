package Contest_4_Love_Bubber;
public class Cn_Encode_The_String {
    
    public static String encodeString(int n, String s) {
        // Write your code here.
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
            {
                char ch = (char)(s.charAt(i) + 1);
                str.append(ch);
            }
            else
            {
                char ch = (char)(s.charAt(i) - 1);
                str.append(ch);
            }

        }
        return str.toString();
        
      }

}
