//https://leetcode.com/problems/guess-number-higher-or-lower/
public class LeetCodeGuessNumberHigherOrLower {
    public static int guessNumber(int n) {
        int mid = 1;
        int right = n;
        int left = 1;
        int hint;
        while (right != left) {
            mid = (left + right)/2;
            hint = guess(mid);
            if (hint == -1) {
                right = mid;
            } else if(hint == 1) {
                left = mid;
            } else if (hint == 0) {
                break;
            }
        }
        return mid;
    }

    private static int guess(int n) {
        return -1;
    }
}
