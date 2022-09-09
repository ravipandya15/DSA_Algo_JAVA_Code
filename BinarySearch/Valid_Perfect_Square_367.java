package BinarySearch;

public class Valid_Perfect_Square_367 {

    // TC -> O(sqrt(N))
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0)
        {
            num = num - i;
            i = i + 2;
        }
        return num == 0;
    }

    // Newton's method -> check in google
    public boolean isPerfectSquare_1(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }

    // O(Log(N))
    public boolean isPerfectSquare_2(int num) {
        int ans = binarySearch(num);
        if (ans * ans == num) return true;
        return false;
    }

    public static int binarySearch(int num)
    {
        int s = 0, e = num;
        int mid = s + (e-s)/2;

        int ans = -1;
        while (s <= e)
        {
            long square = mid * mid;
            if (square == num)
            {
                return mid;
            }
            else if (square < num)
            {
                ans = mid;
                s = mid + 1;
            }
            else
            {
                e = mid - 1;
            }
            mid = s + (e-s)/2;
        }
        return ans;
    }
}
