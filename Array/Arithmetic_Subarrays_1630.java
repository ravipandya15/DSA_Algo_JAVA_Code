package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arithmetic_Subarrays_1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        int m = l.length;

        for (int i = 0; i < m; i++)
        {
            int beg = l[i], end = r[i];
            int[] temp = Arrays.copyOfRange(nums, beg, end + 1);
            Arrays.sort(temp);
            boolean flag = true;
            for (int j = 2; j < end - beg + 1; j++)
            {
                if (temp[j] - temp[j-1] != temp[1] - temp[0])
                {
                    flag = false;
                    break;
                }
            }
            if (flag)
            {
                ans.add(true);
            }
            else
            {
                ans.add(false);
            }
        }
        return ans;
    }
}
