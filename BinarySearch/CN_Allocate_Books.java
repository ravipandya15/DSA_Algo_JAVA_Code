package BinarySearch;
import java.util.ArrayList;

class CN_Allocate_Books
{
	public static void main(String Args[])
	{
		System.out.println("Allocate Books");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.add(40);
        int n = 4; // no of books -> Length of array
        int m = 2; // no. of student
        System.out.println("Answer is " + allocateBooks(arr, n, m));
	}
	
	public static boolean IsPossible(ArrayList<Integer> arr, int n, int m, int mid)
    {
        int studentCount = 1;
        int pageSum = 0;
        for (int i = 0; i < n; i++)
        {
            if (pageSum + arr.get(i) <= mid)
            {
                pageSum += arr.get(i);
            }
            else
            {
                studentCount++;
                if (studentCount > m || arr.get(i) > mid)
                {
                    return false;
                }
                pageSum = 0;
                pageSum += arr.get(i); // instead of that directly we can write pageSum = arr[i]; 
            }
        }

        return true;
    }
	
	public static int allocateBooks(ArrayList<Integer> arr, int n, int m)
    {
        int start = 0;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += arr.get(i);
        }
        int end = sum;
        int ans = -1;
        int mid = start + (end - start) / 2;

        while (start <= end)
        {
            if (IsPossible(arr, n, m, mid))
            {
                ans = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return ans;
    }
}