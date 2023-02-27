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

class SubtreeofAnotherTree {
    // time: O(n), space: O(1)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // pre-order traverse all nodes of root

        // base case
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }

        // if the current node matches subRoot's root, then check if subRoot is a sub
        // root of root
        if (root.val == subRoot.val) {
            // recurse to check if both trees match
            if (isSubtree2(root.left, subRoot.left) && isSubtree2(root.right, subRoot.right)) {
                return true;
            }
        }

        // recurse
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        // pre-order traverse all nodes of root

        // base case
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }

        // if the current node matches subRoot's root, then check if subRoot is a sub
        // root of root
        if (root.val == subRoot.val) {
            // recurse to check if both trees match
            if (isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right)) {
                return true;
            }
        }

        return false;
    }
}