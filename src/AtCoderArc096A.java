import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AtCoderArc096A {

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int ab = 2 * c;
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println(solution2(a, b, ab, x, y));
    }

    private static long solution(int a, int b, int ab, int x, int y) {
        long price = 0;
        if (a + b > ab) {
            if (x > y) {
                int tmp = x - y;
                price += (ab * y);
                if (a > ab) {
                    price += (tmp * ab);
                } else {
                    price += (tmp * a);
                }
            } else {
                int tmp = y - x;
                price += (ab * x);
                if (b > ab) {
                    price += (tmp * ab);
                } else {
                    price += (tmp * b);
                }
            }
            return price;
        } else {
            price += (a * x) + (b * y);
            return price;
        }
    }

    private static long solution2(int a, int b, int ab, int x, int y) {
        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= 100000; i ++) {
            int numX = (x - i > 0) ? x - i : 0;
            int numY = (y - i > 0) ? y - i : 0;
            long price = (numX * a) + (numY * b) + (i * ab);
            if (ans > price) ans = price;
        }
        return ans;
    }
}
