public class LeetCode26RemoveDuplicatesFromSortedArray {
    public static void main(String args[]) {
        LeetCode26RemoveDuplicatesFromSortedArray clazz = new LeetCode26RemoveDuplicatesFromSortedArray();
        int [] nums = {1,1,2};
        System.out.println("output: " + clazz.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int j = 0;
        int keep = nums[0];
        for (int i = 0; i < nums.length; i ++) {
            if (keep != nums[i]) {
                j ++;
                nums[j] = nums[i];
            }
            keep = nums[i];
        }

        for (int num : nums) System.out.println(num);
        return j + 1;
    }
}
