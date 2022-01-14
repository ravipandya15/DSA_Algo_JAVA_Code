package String;

public class Reverse_Words_in_a_String_III_557 {
    public static String Reverse(char[] arr)
{
    int s = 0;
    int e = arr.length - 1;
    while (s <= e)
    {
        // swap;
        char ch = arr[s];
        arr[s] = arr[e];
        arr[e] = ch;
        s++;
        e--;
    }
    return String.valueOf(arr);
}

public String reverseWords(String s) {
    String splitArray[] = s.split(" ");
    int n = splitArray.length;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++)
    {
        sb.append(Reverse(splitArray[i].toCharArray()));
        if (i != n-1) sb.append(" ");
    }
    return sb.toString();
}
    
}
