//https://leetcode.com/problems/climbing-stairs/
public class LeetCodeClimbingStairs {
    public static void main(String args[]) {

    }
    public static int climbStairs(int n) {
        return solution(0, n);
    }

    //TODO the current way is pretty much brute force. Think of a better way applying some dp solution
    private static int solution(int current, int n) {

        if (n < current) {
            return 0;
        }

        if (n == current) {
            return 1;
        }

        return solution(current + 1, n) + solution(current + 2, n);
    }
}
