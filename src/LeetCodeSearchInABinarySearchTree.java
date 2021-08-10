//https://leetcode.com/problems/search-in-a-binary-search-tree/solution/
public class LeetCodeSearchInABinarySearchTree {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(10);
        TreeNode found = better(root, 7);
        System.out.println(found == null ? null : found.val);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root != null && root.val == val) {
            return root;
        }
        if (root == null || (root.right == null && root.left == null)) {
            return null;
        }

        TreeNode match = null;
        if (root != null && root.val > val) {
            match = searchBST(root.left, val);
        } else if (root != null && root.val < val){
            match = searchBST(root.right, val);
        } else {
            return null;
        }
        return match == null ? null : match;
    }

    public static TreeNode better(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return (val > root.val) ? searchBST(root.right, val) : searchBST(root.left, val);
    }

    public static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
