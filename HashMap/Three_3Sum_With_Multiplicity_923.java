package HashMap;

public class Three_3Sum_With_Multiplicity_923 {
    
    public int threeSumMulti(int[] arr, int target) {
        // use array as size of array will not be more than 100


        // test case : in which I have a doubt
        // {1,2,4} k = 4
        // i = 1, j = 1, k = (4 - i - j) = 2
        // so i == j && j != k condition will become true
        // but c[1] = 1
        // c[i] * (c[i] - 1) / 2 * c[k]; = 0 because (c[1] - 1) = 0

        long[] c = new long[101];
        for (int a : arr) c[a]++;
        long res = 0;
        for (int i = 0; i <= 100; i++)
            for (int j = i; j <= 100; j++)
            {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k)
                    res += c[i] * (c[i] - 1) * (c[i] - 2) / 6;
                else if (i == j && j != k)
                    res += c[i] * (c[i] - 1) / 2 * c[k];
                else if (i < j && j < k)
                    res += c[i] * c[j] * c[k];
            }
        return (int)(res % (1e9 + 7));
    }
}
