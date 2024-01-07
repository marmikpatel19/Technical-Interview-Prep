class LongestHappyString {
    /**
    traverse a, b, c by descending.

    Repeatedly add two instance of the current letter along with one instance of the 
    next letter. Move on to the next letter when the currrent one runs out.
    
    e.g., 
    a = 1, b = 1, c = 7

    sort: c, a, b

    cc + a + cc + b + cc
     */

     // time: O(a + b + c), space: O(1)
     public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair<Integer, Character>> maxHeap = 
            new PriorityQueue<>((node1, node2) -> (node2.getKey() - node1.getKey())); // comparison logic for maxHeap

        // we don't want 0's as it means that the letter cannot be added
        if(a > 0){maxHeap.add(new Pair<Integer, Character>(a, 'a'));}
        if(b > 0){maxHeap.add(new Pair<Integer, Character>(b, 'b'));}
        if(c > 0){maxHeap.add(new Pair<Integer, Character>(c, 'c'));}

        while(!maxHeap.isEmpty()){
            Pair<Integer, Character> curr = maxHeap.remove();
            int count1 = curr.getKey();

            // two cases: three instances of curr and can't add it or no issue with adding
            if(sb.length() >= 2 && 
                sb.charAt(sb.length() - 1) == curr.getValue() 
                && sb.charAt(sb.length() - 2) == curr.getValue()){
                    // since we can't add any more of ther current letters, add a letter of 
                    // the next most frequency

                    if(maxHeap.isEmpty()){break;}
                    
                    Pair<Integer, Character> next = maxHeap.remove();
                    sb.append(next.getValue());
                    int count2 = next.getKey();
                    count2--;

                    if(count2 != 0){
                        maxHeap.add(new Pair<Integer, Character>(count2, next.getValue()));
                    }
            }
            else{
                sb.append(curr.getValue());
                count1--;
            }

            if(count1 != 0){
                maxHeap.add(new Pair<Integer, Character>(count1, curr.getValue()));
            }
        }

        return sb.toString();
    }   
}