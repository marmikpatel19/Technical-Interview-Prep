import java.util.HashMap;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class LinkedListCycle {
    // time: O(n), space: O(n)
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> nodes = new HashMap<>();

        // we reuse head to iterate through the list
        while (head != null) {
            // if node is not in nodes, insert it; otherwise, a repetition (loop) has been
            // found
            if (nodes.get(head) == null) {
                nodes.put(head, 1);
            } else {
                return true;
            }

            head = head.next;
        }

        return false;
    }
}