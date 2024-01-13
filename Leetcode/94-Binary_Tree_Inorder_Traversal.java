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

class BinaryTreeInorderTraversal {
    // time: O(V), space: O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new LinkedList<>();
        helper(root, inOrder);
        return inOrder;
    }

    private void helper(TreeNode root, List<Integer> inOrder){
        if(root == null){return;}
        helper(root.left, inOrder);
        inOrder.add(root.val);
        helper(root.right, inOrder);
    }
}