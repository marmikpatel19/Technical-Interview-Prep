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

class DiameterofBinaryTree {
    int max;

    // time: O(n), space: O(1)
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;

        findLongest(root);

        return max;
    }

    private int findLongest(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        int longestLeft = findLongest(root.left);
        int longestRight = findLongest(root.right);

        // the max is has already been found or it is the max of the current root
        max = Math.max(max, longestLeft + longestRight);

        // due to recursion, only return the longest path from current root
        return Math.max(longestLeft, longestRight) + 1;
    }
}