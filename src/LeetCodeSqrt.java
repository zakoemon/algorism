public class LeetCodeSqrt {
    public static void main(String args[]) {
        LeetCodeSqrt leetCodeSqrt = new LeetCodeSqrt();
//        System.out.println(leetCodeSqrt.mySqrt(10));
        int a = 15 >> 2;
        int b = a >> 2;
        int c = b << 1;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
    public int mySqrt(int x) {
        int n = 0;
        long mu;
        while (true) {
            n++;
            mu = n * n;
            if (mu == x) break;
            if (mu > x) {
                n --;
                break;
            }
        }
        return n;
    }
}
