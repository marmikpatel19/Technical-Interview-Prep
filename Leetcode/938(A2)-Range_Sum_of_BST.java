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

    iterative solution: 
     */

    // time: O(n), space: O(n)
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){return 0;}

        int sum = 0;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()){
            TreeNode curr = s.pop();
            if(curr.val < high && curr.val > low){
                sum+=curr.val;
                if(curr.left != null){s.push(curr.left);}
                if(curr.right != null){s.push(curr.right);}
                continue;
            }else if(curr.val <= low){
                if(curr.val == low){sum+=curr.val;}
                if(curr.right != null){s.push(curr.right);}
                continue;
            }else{ // curr.val >= high
                if(curr.val == high){sum+=curr.val;}
                if(curr.left != null){s.push(curr.left);}
            }
        }

        return sum;
    }
}