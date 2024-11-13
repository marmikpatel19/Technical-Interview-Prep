class BinaryTreeVerticalOrderTraversal {
    public class NodeWithColumn{
        TreeNode root;
        int col;
        public NodeWithColumn(TreeNode root, int col){
            this.root = root;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null){return new ArrayList<>();}

        HashMap<Integer, List<Integer>> colToNodes = new HashMap<>();
        int left = 0;
        int right = 0;

        Queue<NodeWithColumn> q = new LinkedList<>();
        NodeWithColumn rootWCol = new NodeWithColumn(root, 0);
        q.add(rootWCol);

        while(!q.isEmpty()){
            // process current node
            NodeWithColumn node = q.remove();
            if(colToNodes.containsKey(node.col)){
                colToNodes.get(node.col).add(node.root.val);
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(node.root.val);
                colToNodes.put(node.col, l);
            }

            // update range
            left = Math.min(left, node.col);
            right = Math.max(right, node.col);

            // process children, left to right
            if(node.root.left != null){
                NodeWithColumn l = new NodeWithColumn(node.root.left, node.col - 1);
                q.add(l);
            }
            if(node.root.right != null){
                NodeWithColumn r = new NodeWithColumn(node.root.right, node.col + 1);
                q.add(r);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = left; i < right + 1; i++){
            res.add(colToNodes.get(i));
        }
        
        return res;
    }
}