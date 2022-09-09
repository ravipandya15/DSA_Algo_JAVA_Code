package Array.Tow_Pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection_of_Two_Arrays_II_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int n = nums1.length, m = nums2.length;
        while (i < n && j < m)
        {
            if (nums1[i] == nums2[j])
            {
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] > nums2[j])
            {
                j++;
            }
            else
            {
                i++;
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}
