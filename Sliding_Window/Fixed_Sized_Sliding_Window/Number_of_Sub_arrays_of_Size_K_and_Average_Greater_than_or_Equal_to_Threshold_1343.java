package Sliding_Window.Fixed_Sized_Sliding_Window;

public class Number_of_Sub_arrays_of_Size_K_and_Average_Greater_than_or_Equal_to_Threshold_1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, count = 0;
        int i = 0, j = 0;
        while (j < arr.length)
        {
            sum += arr[j];
            if (j - i + 1 < k)
            {
                j++;
            }
            else if (j - i + 1 == k)
            {
                if ((sum / k) >= threshold) count++;
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return count;
    }
}
