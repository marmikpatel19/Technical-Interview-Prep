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

class SymmetricTree {
    // time: O(n), space: O(1)
    public boolean isSymmetric(TreeNode root) {
        // flip right subtree of root
        flipTree(root.right);

        // compare if subtres are similar
        return isSame(root.left, root.right);
    }

    private void flipTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        flipTree(root.left);
        flipTree(root.right);
    }

    private boolean isSame(TreeNode nodeOne, TreeNode nodeTwo) {
        if (nodeOne == null && nodeTwo == null) {
            return true;
        } else if (nodeOne == null && nodeTwo != null) {
            return false;
        } else if (nodeOne != null && nodeTwo == null) {
            return false;
        } else if (nodeOne.val != nodeTwo.val) {
            return false;
        }

        return isSame(nodeOne.left, nodeTwo.left) && isSame(nodeOne.right, nodeTwo.right);
    }
}