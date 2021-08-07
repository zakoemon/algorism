import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i = 1; i <= t; ++ i) {
            int [][] arr = new int[3][3];
            for(int r = 0; r < 3; r ++) {
                for(int j = 0; j < 3; j ++) {
                    if(r == 1 && j == 1) continue;
                    arr[r][j] = in.nextInt();
                }
            }
            System.out.println("Case #" + i + ": " + solve(arr));
        }
    }

    public static int solve(int[][] grid) {

        Set<Integer> sets = new HashSet<>();
        sets.add(getTheNum(grid[0][0], grid[2][2]));
        sets.add(getTheNum(grid[2][0], grid[0][2]));
        sets.add(getTheNum(grid[1][0], grid[1][2]));
        sets.add(getTheNum(grid[0][1], grid[2][1]));
        int retNum = 0;
        for (Integer num : sets) {
            retNum = Math.max(retNum, count(num, grid));
        }
        return retNum;
    }

    public static int count(int missing, int grid[][]) {
        int counter = 0;
        grid[1][1] = missing;
        if (isProgression(grid[0][0], grid[1][1], grid[2][2])) {
            counter ++;
        }
        if (isProgression(grid[2][0], grid[1][1], grid[0][2])) {
            counter ++;
        }

        if (isProgression(grid[0][0], grid[0][1], grid[0][2])) {
            counter ++;
        }
        if (isProgression(grid[1][0], grid[1][1], grid[1][2])) {
            counter ++;
        }
        if (isProgression(grid[2][0], grid[2][1], grid[2][2])) {
            counter ++;
        }

        if (isProgression(grid[0][0], grid[1][0], grid[2][0])) {
            counter ++;
        }
        if (isProgression(grid[0][1], grid[1][1], grid[2][1])) {
            counter ++;
        }
        if (isProgression(grid[0][2], grid[1][2], grid[2][2])) {
            counter ++;
        }
        return counter;
    }

    public static boolean isProgression(int one, int two, int three) {
        return (two - one) == (three - two);
    }

    public static int getTheNum(int one, int three) {
        int diff = Math.max(one, three) - Math.min(one, three);
        if (diff % 2 == 0) {
            return (diff / 2) + Math.min(one, three);
        } else {
            return -1;
        }
    }
}
