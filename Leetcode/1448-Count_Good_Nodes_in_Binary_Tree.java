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

class CountGoodNodesinBinaryTree{
    Integer numGoods = 0;

    // time: O(n), space: O(log(n))
    public int goodNodes(TreeNode root) {
        if(root != null) numGoods+=1;

        // DFS to calculate good nodes
        traverse(root.left, root.val);
        traverse(root.right, root.val);

        return numGoods;
    }

    private void traverse(TreeNode root, int curMax){
        // base case
        if(root == null) return;

        // good node
        if(root.val >= curMax){
            numGoods+=1;

            traverse(root.left, root.val);
            traverse(root.right, root.val);
        }
        else{
            traverse(root.left, curMax);
            traverse(root.right, curMax);
        }
    }
}