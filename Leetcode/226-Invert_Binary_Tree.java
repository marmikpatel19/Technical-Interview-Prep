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

class InvertBinaryTree {
    // time: O(n), space: O(1)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        invertNodes(root);

        return root;
    }

    // recursive helper
    private void invertNodes(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        // switch nodes
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        // recursive calls
        invertNodes(root.left);
        invertNodes(root.right);
    }
}