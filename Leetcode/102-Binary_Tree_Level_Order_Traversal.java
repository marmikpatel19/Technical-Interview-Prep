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

class BinaryTreeLevelOrderTraversal {
    /**
    BFS but we use a temp queue within each traversal to store
    all current level nodes.
     */

    // time: O(V), space: O(V) (queue at the largest point can be n/2 in size (binary) => O(n))
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){return new ArrayList<>();}

        Queue<TreeNode> BFSQueue = new LinkedList<>();
        BFSQueue.add(root);
        List<List<Integer>> res = new ArrayList<>();

        while(!BFSQueue.isEmpty()){
            Queue<TreeNode> tempBFSQueue = new LinkedList<>();
            List<Integer> currList = new ArrayList<>();

            while(!BFSQueue.isEmpty()){
                TreeNode currNode = BFSQueue.remove();
                    
                if(currNode.left != null){tempBFSQueue.add(currNode.left);}
                if(currNode.right != null){tempBFSQueue.add(currNode.right);}

                currList.add(currNode.val);
            }

            res.add(currList);            
            
            BFSQueue = tempBFSQueue;
        }

        return res;
    }
}