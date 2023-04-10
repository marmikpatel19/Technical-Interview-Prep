class MinStackNode{
    int val;
    int min; // each node keeps track of the min value discouvered so far
    MinStackNode next;

    public MinStackNode(){}

    public MinStackNode(int val, int min){
        this.val = val;
        this.min = min;
    }
}

class MinStack {
    MinStackNode head;

    public MinStack() {}
    
    public void push(int val) {
        if(head == null){
            head = new MinStackNode(val, val);
        }
        else{
            MinStackNode tempHead = head;
            head = new MinStackNode(val, Math.min(val, head.min));
            head.next = tempHead;
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}
