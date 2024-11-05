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

class LowestCommonAncestorofaBinaryTree {
    /**
    DFS with search for p and q. Given that P and Q must be in the tree, if
    a child DFS call returns p or q return that up. If both left and right 
    return P and Q, then root must be the LCA, return that up. If we end up 
    only bubbling up one, then that is both P/Q and the ancestor of the other
    P/Q.
     */

    // time: O(n), space: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base cases
        if(root == null){return null;}
        if(root == p || root == q){return root;}

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){return root;}
        else if(left != null){return left;}
        else if(right != null){return right;}
        return null;
    }
}