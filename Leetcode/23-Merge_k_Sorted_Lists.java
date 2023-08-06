import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

class MergekSortedLists {
    /*
     * Brute force: Iterate through all the lists, sorting the first one with each
     * list
     * time: O(n*m), space: O(n*m), where n is lists.length and m =
     * longest_list.size()
     * 
     * Optimized: compare two lists with one another at a time, repeating until
     * there are just two
     * lists left. I.e., divide by two each time
     * time: O(log(n)*m), since we do log(n) comparisions
     */

    // time: O(log(n)*m), space: O(n*m), where n is lists.length and m =
    // longest_list.size()
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        List<ListNode> mergedLists = Arrays.asList(lists); // since lists' size is immutable

        // Compare pairs of lists
        while (mergedLists.size() > 1) {
            List<ListNode> tempMergedLists = new ArrayList<>();
            for (int i = 0; i < mergedLists.size(); i += 2) {
                tempMergedLists.add(mergeTwoSortedLists(mergedLists.get(i),
                        i + 1 >= mergedLists.size() ? null : mergedLists.get(i + 1)));
            }

            mergedLists = tempMergedLists;
        }

        return mergedLists.get(0);
    }

    // store the new list in l1
    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode tempSorted = new ListNode();
        ListNode iter = tempSorted;

        // create sorted list until the shorter list runs out
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                iter.next = new ListNode(l1.val);
                iter = iter.next;
                l1 = l1.next;
            } else {
                iter.next = new ListNode(l2.val);
                iter = iter.next;
                l2 = l2.next;
            }
        }

        // add in remaining nodes from longer list
        ListNode longerList = l1 == null ? l2 : l1;
        iter.next = longerList;

        return tempSorted.next; // the first node was temporary
    }
}