//https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/
public class LeetCodePrincipleOfRecursion {
    public static void main(String args[]) {
        String input = "hello";
        char[] inputArr = input.toCharArray();
        reverseString(inputArr);
        System.out.println(String.valueOf(inputArr));
    }

    private static void reverseString(char[] s) {
        reverseStringHelper(s, 0, s.length - 1);
    }

    private static void reverseStringHelper(char[] s, int left, int right) {
        if (right == left && s.length % 2 != 0) return;
        char keep = s[left];
        s[left] = s[right];
        s[right] = keep;
        if (right - left == 1 && s.length % 2 == 0) return;
        reverseStringHelper(s, left + 1, right - 1);
    }
}
