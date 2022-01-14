package Bitwise;

public class CN_Make_it_Equal {
    
    public static int makeItEqual(int a, int b, int c) {
        int move = 0;
        while (a != 0 || b != 0 || c != 0)
        {
            int mask = c & 1;
            if ((a & 1) == 1 && (b & 1) == 1)
            {
                if (mask == 0)
                {
                    move = move + 1;
                }
            }
            else if (((a & 1) == 1 && (b & 1) == 0) ||
                     ((a & 1) == 0 && (b & 1) == 1))
            {
                if (mask == 1)
                {
                    move = move + 1;
                }
            }
            else if ((a & 1) == 0 && (b & 1) == 0)
            {
                if (mask == 1)
                {
                    move = move + 2;
                }
            }
            c = c >> 1;
            b = b >> 1;
            a = a >> 1;
        }
        return move;
    }

}
