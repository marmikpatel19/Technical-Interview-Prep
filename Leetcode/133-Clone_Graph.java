
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class CloneGraph {
    /*
     * Traverse the original node using DFS. Maintain an oldToNew HashMap. At each
     * node,
     * check if the clone contains an equivalent; if it doesn't, add it and
     * recursively traverse that node.
     * 
     * The oldToNew HashMap allows storage of the new graph without creating and
     * maintianing a seperate
     * graph data structure for it. Additionally, it functions as a visited check.
     */

    // time: O(V + E), space: O(V)
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> oldToNew = new HashMap<>();
        if (node == null) {
            return null;
        }
        clone(node, oldToNew);
        return oldToNew.get(node);
    }

    private void clone(Node original, HashMap<Node, Node> oldToNew) {
        if (!oldToNew.containsKey(original)) {
            Node cloned = new Node(original.val);
            oldToNew.put(original, cloned);
        }

        for (Node neighbor : original.neighbors) {
            if (!oldToNew.containsKey(neighbor)) {
                clone(neighbor, oldToNew);
            }
            oldToNew.get(original).neighbors.add(oldToNew.get(neighbor));
        }
    }
}