// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class AtCoderConvertSortedArrayToBinarySearchTree {

    public static void main(String args[]) {

        int[] nums = {1, 5, 7, 9, 10};
        TreeNode node = sortedArrayToBST(nums);
        System.out.println(node);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static TreeNode helper(int[] nums, int first, int last) {
        if (last - first == 1) {
            TreeNode node = new TreeNode(nums[first]);
            node.right = new TreeNode(nums[last]);
            return node;
        }
        if (last == first) return new TreeNode(nums[first]);
        int mid = (first + last) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.right = helper(nums, mid + 1, last);
        node.left = helper(nums, first, mid - 1);
        return node;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
