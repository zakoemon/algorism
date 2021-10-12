//https://leetcode.com/problems/path-sum/

import java.util.LinkedList;

/**
 * returns a boolean values to tell if there is a root-leaf that sums up to the targetSum.
 * leaf is a node that has no children.
 */
public class LeetCodePathSum {
    public static void main(String args[]) {

    }

    /**
     * recursive way to solve the problem
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, root.val);
    }

    // TODO can reduce the params by subtracting from the targetNum because the current value = 0 means there is a path
    private static boolean helper(TreeNode root, int targetSum, int current) {
        if (root == null) return false;

        current += root.val;
        if (root.right == null && root.left == null && current == targetSum) {
            return true;
        }
        TreeNode right = root.right;
        TreeNode left = root.left;
        return helper(right, targetSum, current)
                || helper(left, targetSum, current);
    }

    /**
     * iteration way to solve the problem
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum2(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();

        nodeStack.add(root);
        sumStack.add(targetSum - root.val);

        TreeNode current;
        int currentNum;
        while (!nodeStack.isEmpty()) {
            current = nodeStack.pollLast();
            currentNum = sumStack.pollLast();

            if ((current.right == null) && (current.left == null) && (currentNum == 0)) {
                return true;
            }

            if (current.right != null) {
                nodeStack.add(current.right);
                sumStack.add(currentNum - current.right.val);
            }
            if (current.left != null) {
                nodeStack.add(current.left);
                sumStack.add(currentNum - current.left.val);
            }
        }
        return false;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
