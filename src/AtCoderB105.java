import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//https://atcoder.jp/contests/abc106/tasks/abc106_b
public class AtCoderB105 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = scanner.nextInt();
        // divisor =  約数
        int divisors = 0;
        // you can only iterate thru odd nums
        for (int i = 1; i <= n; i += 2) {
            int counter = 0;
            for (int j = 1; j <= i; j ++) {
                if (i % j == 0) {
                    counter ++;
                }
            }

            if (counter == 8) {
                divisors ++;
            }
        }
        System.out.println(divisors);
    }
}
