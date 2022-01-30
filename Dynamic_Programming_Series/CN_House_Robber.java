package Dynamic_Programming_Series;

import java.util.ArrayList;

public class CN_House_Robber {
    
    // space optimization
    // TC -> O(N)
    // SC -> O(1)
    public static long maximumNonAdjacentSum4(ArrayList<Integer> nums) {
		// Write your code here.
        int n = nums.size();
        long prev2 = 0;
        long prev = nums.get(0);

        for (int i = 1; i < n; i++)
        {
            long pick = nums.get(i);
            if (i -2 >= 0) pick += prev2;

            long not_pick = prev;

            long curi = Math.max(pick, not_pick);

            prev2 = prev;
            prev = curi;
        }

        return prev;
	}

    public static long houseRobber(int[] valueInHouse) {
		// Write your code here.
        int n = valueInHouse.length;
        if (n == 1) return valueInHouse[0];

        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();

        
        for (int i = 0; i < n; i++)
        {
            if (i != 0) arr1.add(valueInHouse[i]);
            if (i != n-1) arr2.add(valueInHouse[i]);
        }

        return Math.max(maximumNonAdjacentSum4(arr1), maximumNonAdjacentSum4(arr2));
	}

}
