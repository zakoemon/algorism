//https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/
public class LeetCodeMaximumDepthOfBinaryTree {
    public static void main(String args[]) {

    }

    public static int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    public static int helper(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth ++;

        int right = helper(root.right, depth);
        int left = helper(root.left, depth);
        return (right >= left)? right : left;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
