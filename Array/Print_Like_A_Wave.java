package Array;

// leetcode 232
public class Print_Like_A_Wave {
    public static void main(String[] args)
    {
        System.out.println("CN) Print Like a Wave");

    }

    public static int[] wavePrint(int arr[][], int nRows, int mCols) {
        int size = arr.length*arr[0].length;
		int result[] = new int[size];
        int i = 0;

        for (int col = 0; col < mCols; col++)
        {
            if ((int)(col & 1) == 1)
            {
                // Odd index -> Bottom to Top
                for (int row = nRows-1; row >= 0; row--)
                {
                    result[i++] = arr[row][col];
                }
            }

            else
            {
                // Even or 0 index -> Top to Bottom
                for (int row = 0; row < nRows; row++)
                {
                    result[i++] = arr[row][col];
                }
            }
        }

        return result;
	}
}
