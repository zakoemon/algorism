//https://leetcode.com/problems/plus-one/submissions/
public class LeetCodePlusOne {
    public static void main(String args[]) {
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        /*
        3 points to consider
        1: if your current element is 9, put 0 and add one to the next
        2: if your current element is not 9, add 1 to it and return the arr
        3: if all the numbers are 9, since it's decimal, you only have to consider the arr size and the first elem.
         */
        for (int i = n; i >= 0; i --) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] ++;
                return digits;
            }
        }
        // here because all the numbers were 9
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
