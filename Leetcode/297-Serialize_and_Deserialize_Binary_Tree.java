class SerializeandDeserializeBinaryTree {
    /**
    dfs with pre-order traversal. N used to identify null. 
    e.g., example 1 becomes "1 2 N N 3 4 N N 5 N N"

    serialize: pre-order DFS traversal. To visit a node, add it into the 
    word. add nulls too. 

    deserialize: use a interator i. given a number, create a node and recurse 
    on left node and right node (i would be update to enable right node). base
    cases are null. 
     */

    // time: O(n), space: O(n)

    private class MutableInt{
        int val;
        MutableInt(int x){val = x;}
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serialized = new StringBuilder();
        if(root != null){dfsSerialize(root, serialized);}
        if(serialized.length() > 1){serialized.setLength(serialized.length() - 1);}
        return serialized.toString();        
    }

    private void dfsSerialize(TreeNode root, StringBuilder serialized){
        if(root == null){
            serialized.append("N,");
            return;
        }
        serialized.append(root.val + ",");
        dfsSerialize(root.left, serialized);
        dfsSerialize(root.right, serialized);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){return null;}

        String[] splitData = data.split(",");
        return dfsDeserialize(splitData, new MutableInt(0));
    }

    private TreeNode dfsDeserialize(String[] splitData, MutableInt i){
        if(i.val >= splitData.length){return null;}
        if(splitData[i.val].equals("N")){
            i.val++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(splitData[i.val]));
        
        i.val++;
        node.left = dfsDeserialize(splitData, i);
        node.right = dfsDeserialize(splitData, i);

        return node;
    }
}