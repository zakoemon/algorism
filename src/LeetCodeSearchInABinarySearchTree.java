
public class LeetCodeSearchInABinarySearchTree {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        TreeNode found = searchBST(root, 8);
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

    public static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
