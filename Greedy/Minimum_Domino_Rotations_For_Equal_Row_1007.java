package Greedy;

public class Minimum_Domino_Rotations_For_Equal_Row_1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int[] topsCount = new int[7], bottomsCount = new int[7], sameCount = new int[7];
        for (int i = 0; i < n; i++)
        {
            topsCount[tops[i]]++;
            bottomsCount[bottoms[i]]++;
            if (tops[i] == bottoms[i])
            {
                sameCount[tops[i]]++;
            }
        }

        for (int i = 1; i < 7; i++)
        {
            if (topsCount[i] + bottomsCount[i] - sameCount[i] == n)
            {
                return n - Math.max(topsCount[i], bottomsCount[i]);
            }
        }
        return -1;
    }
}
