//https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class LeetCodeMinimumDepthOfBinaryTree {
    public static void main(String args[]) {

    }

    public static int minDepth(TreeNode treeNode) {
        return helper(1, treeNode);
    }

    public static int helper(int depth, TreeNode treeNode) {
        if (treeNode.left == null && treeNode.right == null) {
            System.out.println(depth);
            return depth;
        }
        int left = Integer.MAX_VALUE;
        if (treeNode.left != null) {
            left = helper(depth + 1, treeNode.left) ;
        }
        int right = Integer.MAX_VALUE;
        if (treeNode.right != null) {
            right = helper(depth + 1, treeNode.right) ;
        }
        return Math.min(left, right);
    }
}
