class LowestCommonAncestorofaBinaryTreeIII {
    /**
    Brute force: use visited array. traverse both p and q to null
    when traverse q, once currNode is in visited, return currNode.
    Time: O(n), spacek O(n + n)

    Two-pass apporach: Determine the depths of the nodes. Iterate 
    p and q until they're at the same depth. Iterate them together
    until arriving at the same node.
    time: O(n), space: O(n) (no array but still recursive stack)
     */
    // time: O(n), space: O(n)
    public Node lowestCommonAncestor(Node p, Node q) {
        int pDepth = 0;
        int qDepth = 0;

        // determine depths 
        Node pPointer = p;
        Node qPointer = q;
        while(pPointer!=null){
            pPointer = pPointer.parent;
            pDepth++;
        }
        while(qPointer!=null){
            qPointer = qPointer.parent;
            qDepth++;
        }

        // get p and q to the same level
        while(p!= null && q!= null && pDepth!=qDepth){
            if(pDepth > qDepth){
                p = p.parent;
                pDepth--;
            }else{
                q = q.parent;
                qDepth--;
            }
        }

        // find LCA
        while(p!= null && q!= null){
            if(p.val == q.val){
                return p;
            }

            p = p.parent;
            q = q.parent;
        }

        return null;
    }
}