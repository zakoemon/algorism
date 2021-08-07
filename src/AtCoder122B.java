import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://atcoder.jp/contests/abc122/tasks/abc122_b
public class AtCoder122B {
    private static Pattern pettern = Pattern.compile("^(A|C|G|T)*$");
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String str = in.nextLine();
        int longest = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String tmp = str.substring(i, j + 1);
                Matcher m = pettern.matcher(tmp);
                if (m.matches() && longest < tmp.length()) {
                    longest = tmp.length();
                }
            }
        }
        System.out.println(longest);
    }
}