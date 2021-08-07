import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AtCoderDLuckyPin {
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        in.nextLine();
        char[] S = in.nextLine().toCharArray();
        Set<String> possibles = new HashSet<>();
        for (int i = 0; i <= 9; i ++) {
            for (int j = 0; j <= 9; j ++) {
                for (int k = 0; k <= 9; k ++) {
                    char char1 = (char) ('0' + i);
                    char char2 = (char) ('0' + j);
                    char char3 = (char) ('0' + k);
                    char[] digits = new char[3];
                    digits[0] = char1;
                    digits[1] = char2;
                    digits[2] = char3;
                    possibles.add(new String(digits));
                }
            }
        }

        int ans = 0;
        for (String str : possibles) {
            int counter = 0;
            int currentIndex = 0;
            for (int i = 0; i < 3; i ++) {
                for (int j = currentIndex; j < S.length; j ++) {
                    if (str.charAt(i) == S[j]) {
                        counter ++;
                        currentIndex = j + 1;
                        break;
                    }
                }
            }

            if (counter == 3) ans ++;
        }
        System.out.println(ans);
    }
}
