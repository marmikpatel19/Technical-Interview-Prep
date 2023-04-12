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

class LowestCommonAncestorofaBinarySearchTree {
    // Post-order traverse to the bottom. When the recursion unwinds, determine if
    // both elements are found. Soon as
    // they are, return the current element.

    TreeNode LCA = null;

    // time: O(n), space: O(log(n))
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        isFound(root, p, q);

        return LCA;
    }

    private Boolean isFound(TreeNode root, TreeNode p, TreeNode q) {
        // do not traverse if LCA has been found
        if (LCA == null) {
            // base cases
            if (root == null) {
                return false;
            }

            Boolean isFoundLeft = isFound(root.left, p, q);
            if (LCA != null) {
                return true;
            }
            Boolean isFoundRight = isFound(root.right, p, q);
            if (LCA != null) {
                return true;
            }

            // current node is the LCA
            if (isFoundLeft && isFoundRight || root.val == p.val && (isFoundLeft || isFoundRight) ||
                    root.val == q.val && (isFoundLeft || isFoundRight)) {
                LCA = root;
                return true;
            } else {
                // base case
                if (root.val == p.val || root.val == q.val || isFoundLeft || isFoundRight) {
                    return true;
                }

                return false;
            }
        } else {
            return true;
        }
    }
}