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

class RemoveNthNodeFromEndofList {
    // time: O(n^2), space: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode iter = head;

        // find size of list
        while (iter != null) {
            size++;
            iter = iter.next;
        }

        // edge case
        if (size == 1 && n == 1) {
            return null;
        }

        iter = head;
        ListNode prev = new ListNode();
        prev.next = iter;

        // edge case
        if (size == n) {
            return iter.next;
        } else {
            // iterate to the size - n + 2th node
            for (int i = 1; i < size - n + 1; i++) {
                prev = prev.next;
                iter = iter.next;
            }
        }

        // remove node
        prev.next = iter.next;

        return head;
    }
}