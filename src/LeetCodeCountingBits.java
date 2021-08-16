//https://leetcode.com/problems/counting-bits/
public class LeetCodeCountingBits {
    public static void main(String args[]) {

    }

    public static int[] solution(int n) {
        int [] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = popCount(i);
        }
        return ans;
    }

    public static int popCount(int n) {
        int ret = 0;
        while (n != 0) {
            ret ++;
            n = n & (n -1);
        }
        return ret;
    }
}
