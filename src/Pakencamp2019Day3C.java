import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//https://atcoder.jp/contests/pakencamp-2019-day3/tasks/pakencamp_2019_day3_c
public class Pakencamp2019Day3C {
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int student = in.nextInt();
        int song = in.nextInt();
        int score[][] = new int[student][];
        for (int i = 0; i < student; i ++) {
            score[i] = new int[song];
            for (int j = 0; j < song; j++) {
                score[i][j] = in.nextInt();
            }
        }

        long max = 0;
        for (int i = 0; i < song -1 ; i ++) {
            for (int j = i + 1; j < song; j ++) {
                long sum = 0;
                for (int k = 0; k < student; k ++) {
                    sum += Math.max(score[k][i], score[k][j]);
                }
                if (max < sum) max = sum;
            }
        }
        System.out.println(max);
    }
}
