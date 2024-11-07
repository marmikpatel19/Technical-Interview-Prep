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

class RangeSumofBST {
    /* know both recursive and iterative solutions 

    Recursive solution: 
     */

    // time: O(n), space: O(n)
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){return 0;}

        int sum = 0;

        if(root.val < high && root.val > low){
            sum+=root.val;
            sum+=rangeSumBST(root.left, low, high);
            sum+=rangeSumBST(root.right, low, high);
            return sum;
        }else if(root.val <= low){
            if(root.val == low){sum+=root.val;}
            sum+=rangeSumBST(root.right, low, high);
            return sum;
        }else{ // root.val >= high
            if(root.val == high){sum+=root.val;}
            sum+=rangeSumBST(root.left, low, high);
            return sum;
        }
    }
}