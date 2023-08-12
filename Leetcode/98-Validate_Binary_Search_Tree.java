// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ValidateBinarySearchTree {
    /*
     * A solution of recursively checking that the left < root && right > root does
     * not work because it
     * does not consider the case where a element deeper in the tree must abide by
     * BST of upper node.
     * e.g.,
     * 5 -> right is 4
     * 4 -> left 3 and right 6
     * does not work because 3 is not greater than 5
     * 
     * The approach to handle this case is the store min and max values and pass
     * those down recursively.
     * When going to a left node, check if the value is between min and the parent.
     * If it succeeds, update max.
     * When going to a right node, check if the value is between the parent and max.
     * If it succeeds, update min.
     * Initialize min and max to +- infinity.
     */

    // Time: O(n), space: O(n)
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (!(min < root.val && root.val < max)) {
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}