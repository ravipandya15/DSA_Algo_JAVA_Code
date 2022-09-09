package BinarySearch;

public class Guess_Number_Higher_or_Lower_374 {

    public int guess(int n)
    {
        return 0;
        // reutrn -1;
        // return 1;
    }
    public int guessNumber(int n) {
        int low = 0, high = n, mid = 0;

        while (low <= high)
        {
            mid = low + (high - low) / 2;
            int guess = guess(mid);
            if (guess == 0) return mid;
            else if (guess == -1) high = mid - 1;
            else low = mid + 1;
        }
        return mid;
    }
}
