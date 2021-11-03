import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

//https://atcoder.jp/contests/abc077/tasks/arc084_a
public class AtCoderCSnukeFestival {
    public static void main(String args[]) {
//        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        int N = in.nextInt();
//        int[] A = new int[N];
//        int[] B = new int[N];
//        int[] C = new int[N];
//        for (int i = 0; i < N; i++) {
//            A[i] = in.nextInt();
//        }
//        for (int i = 0; i < N; i++) {
//            B[i] = in.nextInt();
//        }
//        for (int i = 0; i < N; i++) {
//            C[i] = in.nextInt();
//        }
//
//        System.out.println(solution(A, B, C));
        int[] i = {1,2,3,3,4,4,5,6};

        int test = Arrays.binarySearch(i, 4);
        System.out.println(test);
    }

    public static long solution(int[] a, int[] b, int[] c) {
        Arrays.sort(a);
        Arrays.sort(b);

        long ans = 0;
        for (int ce : c) {
            int bUpperRange = binarySearch(ce, b);
            if (bUpperRange == -1) continue;
            for (int i = bUpperRange; i >= 0; i --) {
                int cUpperRange = binarySearch(b[i], a);
                if (cUpperRange == -1) continue;
                int howMany = cUpperRange + 1;
                ans += howMany;
            }
        }
        return ans;
    }

    public static int binarySearch(int target, int[] arr) {
        int mid = (0 + (arr.length - 1)) / 2;
        int right = arr.length - 1;
        int left = 0;
        while (right >= left) {
            if (target > arr[mid]) {
                left = mid + 1;
                mid = (left + right)/2;
            } else if (target < arr[mid]) {
                right = mid - 1;
                mid = (left + right)/2;
            } else if (target == arr[mid]) {
                for (int i = mid; i >= 0; i--) {
                   if (target != arr[i]) {
                       return i;
                   }
                }
                return -1;
            }
        }
        return (arr[mid] < target)? mid : -1;
    }
}
