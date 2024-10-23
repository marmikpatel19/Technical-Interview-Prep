class HouseRobberIII {
    /** dp

    At each node:
        if the current node is chosen:
            skip the next set of nodes (children) and recurse on their children
        if the current node is not chosen:
            max of:
                skip the next set of nodes
                include the next set of nodes 

    memo (same patterns are calculated multiple times): make nodes as keys.
    values: [maxSum if included, maxSum if excluded]
    */

    // time: O(n), space: O(n)
    public int rob(TreeNode root) {
        HashMap<TreeNode, int[]> nodeToMaxSums = new HashMap<>();
        return dp(root, false, nodeToMaxSums);
    }

    private int dp(TreeNode node, boolean wasParentIncluded, HashMap<TreeNode, int[]> nodeToMaxSums){
        if(node == null){return 0;}

        if(wasParentIncluded){
            if(nodeToMaxSums.containsKey(node) && nodeToMaxSums.get(node)[1] != -1){
                return nodeToMaxSums.get(node)[1];
            }

            int left = dp(node.left, false, nodeToMaxSums);
            int right = dp(node.right, false, nodeToMaxSums);

            if(nodeToMaxSums.containsKey(node)){
                nodeToMaxSums.get(node)[1] = left + right;
            }else{
                int[] res = new int[2];
                res[0] = -1;
                res[1] = left + right;
                nodeToMaxSums.put(node, res);
            }
            
            return nodeToMaxSums.get(node)[1];
        }else{         
            /* includes current */
            if(!nodeToMaxSums.containsKey(node) || nodeToMaxSums.get(node)[0] == -1){
                int left = dp(node.left, true, nodeToMaxSums);
                int right = dp(node.right, true, nodeToMaxSums);

                if(nodeToMaxSums.containsKey(node)){
                    nodeToMaxSums.get(node)[0] = node.val +left + right;
                }else{
                    int[] res = new int[2];
                    res[0] = node.val + left + right;
                    res[1] = -1;
                    nodeToMaxSums.put(node, res);
                }
            }
            
            /* skip current */
            if(!nodeToMaxSums.containsKey(node) || nodeToMaxSums.get(node)[1] == -1){
                int left = dp(node.left, false, nodeToMaxSums);
                int right = dp(node.right, false, nodeToMaxSums);

                if(nodeToMaxSums.containsKey(node)){
                    nodeToMaxSums.get(node)[1] = left + right;
                }else{
                    int[] res = new int[2];
                    res[0] = -1;
                    res[1] = left + right;
                    nodeToMaxSums.put(node, res);
                }    
            }

            return Math.max(nodeToMaxSums.get(node)[0], nodeToMaxSums.get(node)[1]); 
        }
    }
}