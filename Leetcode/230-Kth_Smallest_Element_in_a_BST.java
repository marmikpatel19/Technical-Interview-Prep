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

class KthSmallestElementinaBST {
    /**
    In-order traversal to go from smallest --> largest due to BST property. 
    Use K as a decrementing variable to measure when we reach the kth smallest value
     */

    /** Multable int and boolean classes as Java does not have pass by reference and wrapper
    types are immutable
     */
    private class MutableInt {
        public Integer value;
        public MutableInt(Integer n){this.value = n;}
    }

    private class MutableBoolean {
        public Boolean value;
        public MutableBoolean(boolean b){this.value = b;}
    }

    // time: O(n), space: O(n)
    public int kthSmallest(TreeNode root, int k) {
        Boolean found = false;
        return helper(root, new MutableInt(k), new MutableBoolean(false));
    }

    // -1 indicates non-kth smallest value
    private int helper(TreeNode root, MutableInt k, MutableBoolean found){
        // determine if we found the smallest value in the tree
        if(root == null){return -1;}

        // in-order traversal with a decrementing k
        int leftValue = helper(root.left, k, found);
        if(!found.value && root.left == null){found.value = true;}
        if(found.value){k.value = k.value - 1;}
        if(k.value == 0){return root.val;}
        int rightValue = helper(root.right, k, found);

        if(leftValue != -1){return leftValue;}
        else if(rightValue != -1){return rightValue;}
        else{return -1;}
    }
}