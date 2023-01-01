/**
 * Definition for singly-linked list.
 */
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

class MergeTwoSortedLists {
    // time: O(n + m), space: O(n + m)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode mergedList = new ListNode(0);
        ListNode p3 = mergedList;

        // travserse list1 and list2, adding the lower element to mergedList
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p3.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                p3.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            p3 = p3.next;
        }

        // if there are still remaining (sorted) nodes in p1 or p2, add them to the end
        // of the new list
        if (p1 != null) {
            p3.next = p1;
        }
        if (p2 != null) {
            p3.next = p2;
        }

        return mergedList.next;
    }
}