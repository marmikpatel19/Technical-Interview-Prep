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

class SumRoottoLeafNumbers{
    /**
    Clarifications
        - can there be repititon of digits? --> yes
        - if the root is a zero, do we basically ignore that so 
            0123 is just 123? 
        - gaurantees on numebrs fitting apppriately in a 32-bit int?
        - are node values ints? 
        - min num nodes? --> n >= 1

    approaches
        - brute force: start at the node and iterate all the way down path
            and store that path. do it for every path. 
            T: worse than O(n^2?), S: O(n^2?)
        - DFS where we build up a solution during traversal. and undo during backtrack
            T(N): O(N), space: O(n)

    tests
        - regular case
        - single node

     */

     public class MutableInt{
        int val;
        public MutableInt(int x){val = x;}
    }

    public int sumNumbers(TreeNode root) {
        MutableInt sum = new MutableInt(0);
        dfs(root, sum, 0);
        return sum.val;
    }

    private void dfs(TreeNode root, MutableInt sum, int currNum){
        // base cases
        if(root == null){return;}
        currNum = currNum * 10 + root.val;
        if(root.left == null && root.right == null){ // leaf node
            sum.val+=currNum;
            return;
        }

        //dfs
        dfs(root.left, sum, currNum);
        dfs(root.right, sum, currNum);
    }   
}