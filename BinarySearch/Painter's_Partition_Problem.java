package BinarySearch;
import java.util.ArrayList;

class Solution
{
	public static void main(String Args[])
	{
		System.out.println("Painter's Partition Problem");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(5);
		arr.add(5);
		arr.add(5);
		arr.add(5);
        int k = 2; // no. of student
        System.out.println("Answer is " + findLargestMinDistance(arr, k));
	}
	
	public static boolean isPossible(ArrayList<Integer> arr, int k, int mid)
    {
        int painterCount = 1;
        int currentTime = 0;
        for (int i = 0; i < arr.size(); i++)
        {
            if (currentTime + arr.get(i) <= mid)
            {
                currentTime += arr.get(i);
            }
            else
            {
                painterCount++;
                if (painterCount > k || arr.get(i) > mid)
                {
                    return false;
                }

                currentTime = 0;
                currentTime += arr.get(i);
            }
        }
        return true;
    }
	
	public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int start = 0;
        int sum = 0;
        for (int i = 0; i < boards.size();i++)
        {
            sum += boards.get(i);
        }
        int end = sum;

        int mid = start + (end - start) / 2;
        int ans = -1;

        while (start <= end)
        {
            if (isPossible(boards, k, mid))
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