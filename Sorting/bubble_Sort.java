package Sorting;

class Solution
{
	public static void main(String Args[])
	{
		System.out.println("Allocate Books");
		int arr[] = {64, 25, 12, 22, 11};
        selectionSort(arr, arr.length);
        System.out.println("After sorting");
        for (int i = 0; i < arr.length; i++)
        {
        	System.out.print(arr[i] + " ");
        }
        
	}
	
	public static void selectionSort(int arr[], int n) {
		for (int i = 1; i < n; i++)
        {
            // improvement for best time complexity O(N)
            boolean swapped = false;
            for (int j = 0; j < n - i; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // update flag
                    swapped = true;
                }
            }

            if (swapped == false)
                break;
        }
	}
}