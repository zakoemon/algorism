import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

//https://atcoder.jp/contests/apg4b/tasks/APG4b_v
public class AtCoderRecursionPractice {
    public static void main(String args[]) {
        int[] arr = {0, 3, 9, 1, 5};
        //System.out.println(solution3(arr, arr.length - 1));
        //System.out.println(solution2(0, 9));
        solution4();
    }

    private static int solution(int n) {
        if (n == 0) {
            return 0;
        }

        return n + solution(n - 1);
    }

    private static int check(int n) {
        int ans = 0;
        for (int i = 0; i <= n; i ++) {
            ans += i;
        }
        return ans;
    }

    private static int solution2(int a, int b) {
        if (a == b) {
            return a;
        }
        return b + solution2(a, b - 1);
    }

    private static int solution3 (int[] input, int index) {
        if (index == 0) {
            return input[0];
        }
        return input[index] + solution3(input, index - 1);
    }

    private static void solution4 () {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt();
        int[] arr = new int[N - 1];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = in.nextInt();
        }

        int[] dp = new int[N];
        for (int i = 0; i < N; i ++) {
            dp[i] = 0;
        }
        System.out.println(rec4(N, arr, 0, dp));
    }

    private static int rec4(int N, int[] arr, int index, int[] dp) {
        if (N - 2 == index) {
            return dp[arr[index]] + 1;
        }
        int cLev = dp[index + 1] = dp[arr[index]] + 1;
        int lev = rec4(N, arr, index + 1 , dp);
        return cLev >= lev ? cLev : lev;
    }
}
