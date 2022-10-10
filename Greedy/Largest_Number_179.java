package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Largest_Number_179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strNums = new String[n];
        for (int i = 0; i < n; i++)
        {
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                String ab = s1 + s2;
                String ba = s2 + s1;
                return ba.compareTo(ab);
            }
        });

        if (strNums[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String str : strNums)
        {
            sb.append(str);
        }
        return sb.toString();
    }
}
