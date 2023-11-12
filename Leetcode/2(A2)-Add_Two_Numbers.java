// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class AddTwoNumbersA2 {
    // time: O(Max(n,m)), space: O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p1 = l1;
        ListNode p2 = l2; 
        ListNode p2_end = null;

        while(p1 != null && p2 != null){
            int sum = p1.val + p2.val + carry;
            carry = 0; 

            if(sum >= 10){
                carry = 1;
                sum -= 10; 
            }

            p2.val = sum;

            if(p2.next == null){p2_end = p2;}
            p1 = p1.next;
            p2 = p2.next;
        }

        if(p1 != null){
            p2_end.next = p1;
            p2 = p1;

            while(p2 != null){
                if(carry == 0){
                    return l2;
                }

                int sum = p2.val + carry;
                carry = 0; 

                if(sum >= 10){
                    carry = 1;
                    sum -= 10; 
                }

                p2.val = sum;
                if(p2.next == null){p2_end = p2;}
                p2 = p2.next;
            }
        }
        else if(p2 != null){
            while(p2 != null){
                if(carry == 0){
                   return l2;
                }

                int sum = p2.val + carry;
                carry = 0; 

                if(sum >= 10){
                    carry = 1;
                    sum -= 10; 
                }

                p2.val = sum;
                if(p2.next == null){p2_end = p2;}
                p2 = p2.next;
            }
        }
        
        if(carry != 0){
            p2_end.next = new ListNode(carry); 
        }

        return l2;
    }
}