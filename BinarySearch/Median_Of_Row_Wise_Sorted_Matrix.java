package BinarySearch;
import java.io.*;
import java.util.ArrayList;

class GFG {
	public static void main (String[] args) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		temp.add(3);
		temp.add(6);
		
		ArrayList<Integer> temp2 = new ArrayList<Integer>();
		temp.add(2);
		temp.add(6);
		temp.add(9);
		
		ArrayList<Integer> temp3 = new ArrayList<Integer>();
		temp.add(3);
		temp.add(6);
		temp.add(9);
		
		arr.add(temp);
		arr.add(temp2);
		arr.add(temp3);
		System.out.println("find median Note : every row is sorted");
		int ans = findMedian(arr);
		System.out.println("Median is " + ans);
	}
	
	public static int findMedian(ArrayList<ArrayList<Integer>> arr)
	{
		int low = Integer.MIN_VALUE;
		int high = Integer.MAX_VALUE;
		int n = arr.size();
		int m = arr.get(0).size();
		while (low <= high)
		{
			int mid = low + (high - low)/2;
			// or mid = (low + high)/2;
			// or mid = (low + high) >> 1;
			int count = 0;
			for (int i = 0; i < n; i++)
			{
				count += countSmallerThanMid(arr.get(i), mid);
			}
			if (count <= (n*m)/2)
				low = mid + 1;
			else
				high = mid -1;
		}
		return low;
	}
	
	private static int countSmallerThanMid(ArrayList<Integer> arr, int val)
	{
		int low = 0;
		int high = arr.size() -1;
		while (low <= high)
		{
			int mid = low + (high - low)/2;
			if (arr.get(mid) <= val)
				low = mid + 1;
			else
				high = mid - 1;
		}
		
		return low;
	}
}