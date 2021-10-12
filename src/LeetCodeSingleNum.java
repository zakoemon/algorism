import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/single-number/
public class LeetCodeSingleNum {
    public static void main(String args[]) {
        int[] nums = {1,2,2,3,3,4,4,5,5,6,6,7,7};
        System.out.println(singleNumber2(nums));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int num;
        //拡張for文 is better
        for (int i = 0; i < nums.length; i ++) {
           num = nums[i];
           //map.getOrDefault is better
           if (map.get(num) != null) {
               map.put(num, map.get(num) + 1);
           } else {
               map.put(num, 1);
           }
        }

        for (Integer integer : nums) {
            if (map.get(integer) == 1) {
                return integer;
            }
        }

        throw new IllegalArgumentException();
    }

    /**
     * by using xor
     * there is a num that only appears once and other numbers appear twice
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        return a;
    }
}
