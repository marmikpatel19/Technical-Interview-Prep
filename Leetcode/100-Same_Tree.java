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

class SameTree {
    // time: O(n) (n - number of nodes), space: O(1)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // check if root is null
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        // check values
        else if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}