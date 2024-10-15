/**
    enqueue: push new elements onto s1: O(1)
    dequeue & print: O(n) or O(1)
        if s2 is empty, we move all the elements from s1 onto s2 and pop/peek the last one
        
        if s2 is not empty, that we just pop/peek the last one
        
        the logic here is that s2 will always have the correct queue order. So even if new
        elements are enqueued--added to s1--s2 will still have the correct queue order. 
        When s2 eventually becomes empty, we can move all s1 elements to it again so that
        the order is now correct. 
*/
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.empty()){
            moveElements(s1, s2);
        }
        
        return s2.pop();
    }
    
    public int peek() {
        if(s2.empty()){
            moveElements(s1, s2);
        }
        
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void moveElements(Stack<Integer> s1, Stack<Integer> s2){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */