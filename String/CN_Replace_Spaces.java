package String;

public class CN_Replace_Spaces {
    public static StringBuilder replaceSpaces(StringBuilder str)
    {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == ' ')
            {
                output.append("@40");
            }
            else
            {
                output.append(str.charAt(i));
            }
        }
        return output;
    }
}
