package HashMap;

import java.util.HashSet;
import java.util.Set;

public class Valid_Square_593 {
    public static long distance(int[] p1, int[] p2)
    {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] dis = new long[] {distance(p1, p2), distance(p1, p3), distance(p1, p4), 
                               distance(p2, p3), distance(p2, p4), distance(p3, p4)};
        
        Set<Long> set = new HashSet<>();
        for (long i : dis)
        {
            if (i == 0) return false; // if distance is 0, we got a duplicate value.
            if (!set.contains(i))
            {
                set.add(i);
            }
        }
        return set.size() == 2; // valid square has only 2 diff. lengths... 1) edges length 2) diagonal lengths
    }
}
