import java.util.Arrays;
import java.util.stream.IntStream;

//https://leetcode.com/problems/maximum-subarray/
public class LeetCodeMaximumSubarray {

    public int solution1(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            int[] subArr = new int[nums.length];
            for (int j = i + 1; j < nums.length; j ++) {
                subArr = Arrays.copyOfRange(nums, i, j);
            }
            int subSum = 0;
            for (int num : subArr) {
                subSum += num;
            }
            if (sum < subSum) sum = subSum;
        }
        return sum;
    }

    public int solution2(int[] nums) {
        return 0;
    }
}
