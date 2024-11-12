class CopyListwithRandomPointer {
    /**
    Clarifications
         - are we given n?
         - if random points to a node, can I assume that node must be in the list?
         - can I be given an empty list? if so, return a null?
         - cant next == random for a given node? 
        - can I modify original list?  --> NOO
        - can random be itserlf? no, right? 
        - I cant modify the original defintion right?
    approaches
        - recursive approach
            when a new node is created, add to hashmap as a Tuple(old, new)
            // time: O(n), space O(n) -- map
        - iterate through the list. for each node, map node to new node. update new
            node's next and random to match. Do a second pass; at each node, update the 
            new node's next and random. 
            time: O(n), space: O(n)    

    tests
        - random points backward
        - single node
        - general example
     */
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> oldToNew = new HashMap<>();
        Node p = head;

        while(p != null){
            Node newNode = new Node(p.val);
            oldToNew.put(p, newNode);
            p = p.next;
        }

        p = head;
        while(p != null){
            if(p.next != null){
                oldToNew.get(p).next = oldToNew.get(p.next);
            }
            if(p.random != null){
                oldToNew.get(p).random = oldToNew.get(p.random);
            }
    
            p = p.next;
        }

        return oldToNew.get(head);
    }
}