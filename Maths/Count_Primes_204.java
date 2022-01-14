package Maths;

import java.util.Arrays;

public class Count_Primes_204 {
    public static void main(String[] args)
    {
        System.out.println("CN) Print Like a Wave");
    }

    public static int countPrimes(int n) {
        int count = 0;
        // mark all number as prime
        //1->Prime , 0->Non Prime
        int primes[] = new int[n+1];
        Arrays.fill(primes, 1);

        for (int i = 2; i < n; i++)
        {
            if (primes[i] == 1)
            {
                count++;

                // mark number as non prime -> as i is there in table of j.
                for (int j = 2 * i; j < n; j = j + i)
                {
                    primes[j] = 0;
                }
            }
        }
        return count;
    }
}
