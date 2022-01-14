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
		for (int i = 0; i < n - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
            {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            // swap minIndex with i;
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
	}
}