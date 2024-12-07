class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        // find n
        ListNode p = head;
        int n = 0;
        while(p != null){
            p = p.next;
            n++;
        }

        // base cases
        if(n == 0){return null;}
        else if(n == 1){return head;}
        k = k % n;
        if(k == 0){return head;}

        // obtain rotateIndex
        int rotateIndex = 0;
        System.out.println(n);
        System.out.println(k);
        if(n - k > 0){
            rotateIndex = n - k;
        }else if(n - k == 0 || n == k)
            return head;
        else{
            int pos = -1 * (n - k);
            rotateIndex = n - pos;
        }

        // rotate list
        // get to rotateIndex
        p = head;
        int currIndex = 0;
        while(currIndex < rotateIndex){
            ListNode temp = p;
            p = p.next;
            currIndex++;

            if(currIndex == rotateIndex){
                temp.next = null;
            }
        }
        ListNode rotateIndexHead = p;

        // build new List
        // get to end
        while(p.next != null){
            p = p.next;
        }

        p.next = head;

        return rotateIndexHead;
    }
}