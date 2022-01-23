package Recursion;

import java.util.ArrayList;

public class All_Kind_Of_Recursion_Pattens {
    public static void main(String[] args) {
        
       System.out.println("Print_All_Recursion_Whose_Sum_is_K");
        int[] arr = new int[] { 1, 2, 1 };
        int sum = 2;

        var result1 = printAllRecursion(arr, sum);

        var result2 = printAnyOneRecursion(arr, sum);

        var result3 = countSubSeqencesWithSumK(arr, sum);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static void solve1(int index, int[] arr, int sum, int s, ArrayList<ArrayList<Integer>> output,
                                ArrayList<Integer> result, int n)
        {
            // base condition
            if (index == n)
            {
                if (sum == s)
                    output.add(new ArrayList<Integer>(result));
                return;
            }


            // include
            s += arr[index];
            result.add(arr[index]);
            solve1(index + 1, arr, sum, s, output, result, n);
            result.remove(result.size() - 1);
            s -= arr[index];

            // exclude
            solve1(index + 1, arr, sum, s, output, result, n);
        }

        //Print_All_Recursion_Whose_Sum_is_K
        //patern 1
        public static ArrayList<ArrayList<Integer>> printAllRecursion(int[] arr, int sum)
        {
            ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> result = new ArrayList<Integer>();
            solve1(0, arr, sum, 0, output, result, arr.length);
            return output;
        }

        public static boolean solve2(int index, int[] arr, int sum, int s, ArrayList<ArrayList<Integer>> output,
                                ArrayList<Integer> result, int n)
        {
            // base condition
            if (index == n)
            {
                if (sum == s)
                {
                    output.add(new ArrayList<Integer>(result));
                    return true;
                }
                return false;
            }


            // include
            s += arr[index];
            result.add(arr[index]);
            if (solve2(index + 1, arr, sum, s, output, result, n) == true)
                return true;

            result.remove(result.size() - 1);
            s -= arr[index];

            // exclude
            if (solve2(index + 1, arr, sum, s, output, result, n) == true)
                return true;

            return false;
        }

        //Print_Any_One_Recursion_Whose_Sum_is_K
        // patern 2
        public static ArrayList<ArrayList<Integer>> printAnyOneRecursion(int[] arr, int sum)
        {
            ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> result = new ArrayList<Integer>();
            solve2(0, arr, sum, 0, output, result, arr.length);
            return output;
        }

        public static int solve3(int index, int[] arr, int sum, int s, int n)
        {
            // base condition
            if (index == n)
            {
                // condition satisfied
                if (sum == s)
                {
                    return 1;
                }
                // condition not satisfied
                return 0;
            }


            // include
            s += arr[index];
            int left = solve3(index + 1, arr, sum, s, n);
            s -= arr[index];

            // exclude
            int right = solve3(index + 1, arr, sum, s, n);

            return left + right;
        }

        // Count the subsequences with sum k
        // patern 3
        public static int countSubSeqencesWithSumK(int[] arr, int sum)
        {
            return solve3(0, arr, sum, 0, arr.length);
        }
}
