import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtCoderSaikoNoIseki {
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int qu = in.nextInt();
        System.out.println("qu: " + qu);

        List<Dot> dots = new ArrayList<>();
        int counter = 0;

        for (int i = 1; i <= qu; i++) {
            counter ++;
            for (int j = 1; j <= 2; j++) {
                int x = in.nextInt();
                int y = in.nextInt();
                dots.add(new Dot(x, y));
                System.out.println("x: " + x + " y: " + y);
            }
        }
        System.out.println(counter);

    }

    public static class Dot {
        int x;
        int y;
        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double distance(Dot dot) {
            int dx = Math.abs(this.x - dot.x);
            int dy = Math.abs(this.y - dot.y);
            return Math.sqrt(dx * dx + dy * dy);
        }
    }
}
