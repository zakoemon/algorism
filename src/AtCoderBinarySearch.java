import java.io.BufferedReader;
import java.io.InputStreamReader;;

import java.util.Arrays;
import java.util.Scanner;

public class AtCoderBinarySearch {
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int sLen = in.nextInt();
        int s [] = new int[sLen];
        for (int i = 0; i < s.length; i ++) {
            s[i] = in.nextInt();
        }
        int tLen = in.nextInt();
        int t [] = new int[tLen];
        for (int i = 0; i < t.length; i ++) {
            t[i] = in.nextInt();
        }
        solution2(s, t);
    }

    private static void solution(int[] s, int[] t) {
        int counter = 0;
        for (int i = 0; i < t.length; i ++) {
            if (Arrays.binarySearch(s, t[i]) >= 0) {
                counter ++;
            }
        }
        System.out.println(counter);
    }

    private static void solution2(int[] s, int[] t) {
        int ans = 0;
        for (int i = 0; i < t.length; i ++) {
            int left = 0;
            int right = s.length - 1;
            int mid = (left + right) / 2;

            while (left <= right) {
                if (s[mid] == t[i]) {
                    ans ++;
                    break;
                } else if (s[mid] > t[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                mid = (left + right) / 2;
            }
        }
        System.out.println(ans);
    }
}
