package Sliding_Window.Variable_Size_Sliding_Window;

public class Optimal_Partition_of_String_2405 {
    public int partitionString(String s) {
        int n = s.length();
        int[] map = new int[26];
        int count = 0, i = 0, j = 0;
        while (j < n)
        {
            if (map[s.charAt(j) - 'a'] == 1)
            {
                while (i != j)
                {
                    map[s.charAt(i) - 'a'] = 0;
                    i++;
                }
                count++;
            }
            map[s.charAt(j) - 'a'] = 1;
            j++;
        }
        return count + 1;
    }
}
