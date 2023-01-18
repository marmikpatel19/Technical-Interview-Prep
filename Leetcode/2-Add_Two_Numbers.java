// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    // time: O(n), space: O(n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder l1Num = new StringBuilder("");
        StringBuilder l2Num = new StringBuilder("");

        // iterate through the lists, adding the numbers to the string
        while(l1 != null || l2 != null){
            if(l1 != null){
                l1Num.append(l1.val);
                l1 = l1.next; 
            }

            if(l2 != null){
                l2Num.append(l2.val);
                l2 = l2.next; 
            }   
        }

        java.math.BigInteger addedValueInt = new java.math.BigInteger(l1Num.reverse().toString()).add(new java.math.BigInteger(l2Num.reverse().toString()));
        StringBuilder addedValueString = new StringBuilder(String.valueOf(addedValueInt));
        addedValueString.reverse();

        // convert to linkedList
        ListNode sum = new ListNode(Integer.parseInt(((Character) addedValueString.charAt(0)).toString()));
        ListNode sumIncrement = sum; 
        for(int i = 1; i < addedValueString.length(); i++){
            sumIncrement.next = new ListNode(Integer.parseInt(((Character) addedValueString.charAt(i)).toString()));
            sumIncrement = sumIncrement.next;
        }

        return sum;
    }
}