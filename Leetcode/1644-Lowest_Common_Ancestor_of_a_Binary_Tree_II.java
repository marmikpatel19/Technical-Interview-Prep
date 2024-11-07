class LowestCommonAncestorofaBinaryTreeII {
    public class MutableBoolean {
        boolean val;
        MutableBoolean(boolean x){
            val = x;
        }
     }
    // time: O(n), space: O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        MutableBoolean pFound = new MutableBoolean(false);
        MutableBoolean qFound = new MutableBoolean(false);

        TreeNode LCA = dfs(root, p, q, pFound, qFound);

        if(pFound.val && qFound.val){return LCA;}
        return null;
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q, MutableBoolean pFound, MutableBoolean qFound ){
        // base case
        if(root == null){return null;}

        // dfs
        TreeNode l = dfs(root.left, p, q, pFound, qFound);
        TreeNode r = dfs(root.right, p, q, pFound, qFound);

        if(root.val == p.val){
            pFound.val = true;
            return root;
        }
        else if(root.val == q.val){
            qFound.val = true;
            return root;
        }
        else if(l != null && r != null){
            return root;
        }
        else if(l != null){
            return l;
        }
        else if(r != null){ 
            return r;
        }else{ // both l and r are null
            return null;
        }
    }
}