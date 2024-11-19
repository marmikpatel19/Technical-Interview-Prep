/**
clarifications
    - capacity can be zero? or > 0? -> >= 1
    - O(1) *average*
    - key and value are they both ints? 
    - assume that keys are unique 
    - node values do not contain -1
    - clarify understanding of an LRU cache

        keep track of when an element has been
        last used. 
        - if there is get, update that element
        to most recent acceessed
        - if there is put and scucessful update,
        then update that element to most recently
        acceessed.
        - if there is put but max capcaity, 
        remove least frequency used element

approach
    - using arraylist w timestamp, but get and find
    update is O(N)

    - using queue, but difficultt to get something 
    int he middle and that's O(n)

    - Doubly LinkedList w HashMap: T: O(1), S: O(n)
        if we think of an ordering of frequency, what
        we need is a way to get an eleemnt in O(1) from
        the ordering, and move it to the end of the 
        ordering in O(1). we need to be able to
        update it in O(1) too. 

        HashMap: key --> node
        LinkedList --> get an element in O(1), update
        in O(1), if accessed move to the end in O(1)

        DoublyLinkedList to maintain order

        We need dummy first and last nodes to 
        make updating the list easy. 
 */

 class LRUCache {
    public class Node{
        int val;
        int key;
        Node prev;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    HashMap<Integer, Node> keyToNode;
    Node dummyStart; // comes before first node (dummyStart.next = first)
    Node dummyEnd; // comes after last node (dummyStart.prev = last)

    public LRUCache(int capacity) {
        this.capacity = capacity; 
        keyToNode = new HashMap<>();

        // set up dummy nodes, and link them to each other 
        dummyStart = new Node(-1, -1);
        dummyEnd = new Node(-1, -1);
        dummyStart.next = dummyEnd;
        dummyEnd.prev = dummyStart; 
    }
    
    public int get(int key) {
        if(!keyToNode.containsKey(key)){
            return -1;
        }

        // remove and move node
        Node curr = keyToNode.get(key);
        removeNodeFromList(curr);
        addNodeToList(curr);

        return curr.val;
    }
    
    public void put(int key, int value) {
        // if contains, update value and move to last
        if(keyToNode.containsKey(key)){
            // remove and move node
            Node curr = keyToNode.get(key);
            removeNodeFromList(curr);
            addNodeToList(curr);

            curr.val = value;
        }else{
            // at capacity
            if(keyToNode.size() == capacity){
                removeAndDeleteFirst();
            }

            // add new element 
            Node curr = new Node(key, value);    
            addNodeToList(curr);
            keyToNode.put(key, curr);
        }
    }

    public void removeNodeFromList(Node n){ // assume it exists
        n.prev.next = n.next; // update past link to next
        n.next.prev = n.prev; // update next link to past
    }

    public void addNodeToList(Node n){
        Node last = dummyEnd.prev;
        last.next = n;
        n.prev = last;
        n.next = dummyEnd;
        dummyEnd.prev = n; 
    }

    public void removeAndDeleteFirst(){
        Node first = dummyStart.next;
        dummyStart.next = first.next;
        first.next.prev = dummyStart;
        keyToNode.remove(first.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */