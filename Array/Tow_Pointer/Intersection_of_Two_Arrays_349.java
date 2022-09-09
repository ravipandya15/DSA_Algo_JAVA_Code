package Array.Tow_Pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection_of_Two_Arrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
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
                while (i + 1 < n && nums1[i] == nums1[i+1]) i++;
                while (j + 1 < m && nums2[j] == nums2[j+1]) j++;
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
