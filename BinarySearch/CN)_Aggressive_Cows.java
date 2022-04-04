package BinarySearch;
import java.util.ArrayList;
import java.util.Collections;

class Solution
{
	public static void main(String Args[])
	{
		System.out.println("Aggressive Cows");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(4);
		arr.add(2);
		arr.add(1);
		arr.add(3);
		arr.add(6);
        int k = 2; // no. of student
        System.out.println("Answer is " + AggressiveCows(arr, k));
	}
	
	public static boolean IsPossible(ArrayList<Integer> stalls, int k, int mid)
    {
        int cowCount = 1;
        int lastPos = stalls.get(0);

        for (int i = 0; i < stalls.size(); i++)
        {
            if (stalls.get(i) - lastPos >= mid)
            {
                cowCount++;
                if (cowCount == k)
                {
                    return true;
                }
                lastPos = stalls.get(i);
            }
        }
        return false;
    }
	
	public static int AggressiveCows(ArrayList<Integer> stalls, int k)
    {
        Collections.sort(stalls);
        int start = 0;
        int maxi = -1;
        for (int i = 0; i < stalls.size(); i++)
        {
            maxi = Math.max(maxi, stalls.get(i));
        }
        int end = maxi;
        int ans = -1;
        int mid = start + (end - start) / 2;
        while (start <= end)
        {
            if (IsPossible(stalls, k, mid))
            {
                ans = mid;
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return ans;
    }
}