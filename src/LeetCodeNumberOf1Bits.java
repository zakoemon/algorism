//https://leetcode.com/problems/number-of-1-bits/
public class LeetCodeNumberOf1Bits {
    public static void main(String args[]){
        int input = 15;
        System.out.println(solution(input));
        System.out.println(solution2(input));
        System.out.println(Integer.toBinaryString(input));
    }

    public static int solution(int num) {
        int mask = 1;
        int counter = 0;
        for (int i = 0; i < 32; i ++) {
            if ((num & mask) != 0) counter ++;
            mask <<= 1;
        }
        return counter;
    }

    public static int solution2(int num) {
        int counter = 0;
        while (num != 0) {
           num = num & (num - 1);
           ++counter;
        }
        return counter;
    }
}
