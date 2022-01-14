package String;

public class String_Compression_443 {
    
    public int compress(char[] chars) {
        int i = 0;
        int ansIndex = 0;
        int n = chars.length;

        while (i < n)
        {
            int j = i + 1;
            while (j < n && chars[i] == chars[j])
            {
                j++;
            }

            // when we comes here j have some diff character or traversal of full array is completed
            
            // store old character
            chars[ansIndex++] = chars[i];

            int count = j - i;

            if (count > 1)
            {
                // convert count in string
                String str = String.valueOf(count);
                for (char ch : str.toCharArray())
                {
                    chars[ansIndex++] = ch;
                }
            }
            // moving to new diff. character
            i = j;
        }
        return ansIndex;
    }
}
