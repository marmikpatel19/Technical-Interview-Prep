//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class ReorderList{
    /**
    1) find mid point
    2) reverse latter list
    3) insert one after another
     */

     // time : O(n), space: O(1)
     public void reorderList(ListNode head) {
        if(head.next == null || head.next.next == null){return;}

        // find mid point
        ListNode p = head.next;
        ListNode mid = head;

        while(p != null && p.next != null){
            p = p.next.next;
            mid = mid.next;
        }

        // reverse latter list
        ListNode prev = null;
        ListNode cur = mid.next;
        mid.next = null; // break the link between l1 and l2 so that the end of the final list does not point back to itself

        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        // create new list;
        ListNode p1 = head;
        ListNode p2 = prev;
        prev = null;
        while(p1 != null && p2 != null){
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;

            p1.next = p2;
            p2.next = temp1;

            p1 = temp1;
            p2 = temp2;
        }
    }
}