class LowestCommonAncestorofaBinaryTreeIII {
    /**
    Brute force: use visited array. traverse both p and q to null
    when traverse q, once currNode is in visited, return currNode.
    Time: O(n), spacek O(n)

    Two-pass apporach: Determine the depths of the nodes. Iterate 
    p and q until they're at the same depth. Iterate them together
    until arriving at the same node.
    time: O(n), space: O(1)

    One-pass Fast and Slow Pointers approach!: traverse p and q at 
    the same time. when one reaches null (the parent of root), 
    reinitialize it to the *other* pointer. Repeat until p == q.
    This works because p and q will have some depth distance d. 
    Each time we switch the pointers, this depth distance 
    decreases ... until it's 0.
    time: O(n), space: O(1)
     */

    // time: O(n), space: O(1)
    public Node lowestCommonAncestor(Node p, Node q) {
        Node p2 = p;
        Node q2 = q;

        while(p2 == null || q2 == null || p2.val != q2.val){
            if(p2 == null){
                p2 = q;
            }else{
                p2 = p2.parent;
            }
            if(q2 == null){
                q2 = p;
            }else{
                q2 = q2.parent;
            }
        }

        return p2;
    }
}