package Greedy;

import java.util.Arrays;

public class Boats_to_Save_People_881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0, j = n-1;
        int boats = 1, max = limit, count = 0;
        while (i <= j)
        {
            if (count < 2 && max >= people[j])
            {
                count++;
                max -= people[j];
                j--;
            }
            else if (count < 2 && max >= people[i])
            {
                count++;
                max -= people[i];
                i++;
            }
            else
            {
                boats++;
                max = limit;
                count = 0;
            }
        }
        return boats;
    }
}
