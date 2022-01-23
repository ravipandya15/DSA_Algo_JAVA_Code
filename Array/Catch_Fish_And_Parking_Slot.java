package Array;

import java.util.Arrays;
//import java.util.Collections;

public class Catch_Fish_And_Parking_Slot {
    
    // love bubber contest 3
    public static int minimumNet(int n, int k, boolean[] fish)
    {
        int r = -1;
        int count = 0;
        int ans = Integer.MAX_VALUE;

        for (int l = 0; l < n; l++)
        {
            while (r < n - 1 && count < k)
            {
                r++;

                if (fish[r])
                    count++;
            }

            if (count == k)
                ans = Math.min(ans, r - l + 1);

            if (fish[l])
                count--;
        }

        if (ans == Integer.MAX_VALUE)
            return -1;

        return ans;
    }

    // asked in swiggy
    // TC -> O(N) + O(N)
    public static int minLengthRoof(int[] cars, int k)
    {
        Arrays.sort(cars);

        // for reverse ordering
        // Arrays.sort(cars);
        // Collections.reverse(Arrays.asList(cars));
        int n = cars.length;
        int ans = Integer.MAX_VALUE;
        int count = 0;
        int r = -1;

        for (int l = 0; l < n; l++)
        {
            while (r < n-1 && count < k)
            {
                r++;
                count++;
            }

            if (count == k)
                ans = Math.min(ans, cars[r] - cars[l] + 1);

            count--;
        }
        return ans;
    }
}
