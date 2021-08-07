import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_7_B&lang=ja
public class HowManyWays {
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int x = in.nextInt();

        int count = 0;
        for (int i = 1; i <= n - 2; i ++) {
            for (int ii = i + 1; ii <= n - 1; ii ++) {
                for (int iii = ii + 1; iii <= n; iii ++) {
                    if (i + ii + iii == x) {
                        count ++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
