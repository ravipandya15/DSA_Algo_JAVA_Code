package Sorting;

class Solution
{
	public static void main(String Args[])
	{
		System.out.println("Allocate Books");
		int arr[] = {64, 25, 12, 22, 11};
		insertionSort(arr.length, arr);
        System.out.println("After sorting");
        for (int i = 0; i < arr.length; i++)
        {
        	System.out.print(arr[i] + " ");
        }
	}
	
	public static void insertionSort(int n, int[] arr)
    {
        for (int i = 1; i < n; i++)
        {
            int temp = arr[i];
            int j = i - 1;
            for (; j>= 0; j--)
            {
                if (arr[j] > temp)
                {
                    // shift
                    arr[j + 1] = arr[j];
                }
                else
                {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }
}