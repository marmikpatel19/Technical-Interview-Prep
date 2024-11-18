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

class DiameterofBinaryTree {
    /**
    Clatirfications
        - longest minimum path--no reptitions
        - path number od edges not notes
        - empty tree?
        - single node --> 0
    
    approaches
        - greedy approach w dfs. keep a max diameter variable that we check at each visted node.
            max = Math.max(left, right, left = right);
            dfs returns not this max!! but rather max(left, right), b/c if we go
            up, then we would not be using the case where it passes trhough the 
            child node. 

            return max;

            greedy b/c we store the max found at each stage 

            T: O(N), space: O(H)

    tests
        - regular tree
        - not throuhg root 
        - two nodes 
     */

     public class MutableInt{
        int val;
        public MutableInt(int x){
            val = x;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        MutableInt max = new MutableInt(0);
        dfs(root, max);
        return max.val;
    }

    private int dfs(TreeNode root, MutableInt max){
        // bases cases
        if(root == null){return 0;}

        // dfs
        int left = dfs(root.left, max);
        int right = dfs(root.right, max);

        max.val = Math.max(max.val, left + right);
        return Math.max(left, right) + 1;
    }
}