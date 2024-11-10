class KthLargestElementinanArray {
    /**
    clarification
        - sorted order right?
        - can we gaurantee that it exists or should I handle the case that
            it does not?

    Approaches (explain 2 and 3 and ask interviewer which to do)
        - sort it, and then iterate through and return the kth elements
            - O(nlogn), O(n) (from sorting)
        - minheap
            iterate through the array. we want to store the k largest 
            elements in the minheap and then return the root, which 
            would be the kth largest element.

            so, if minheap.size() < n, we insert the element. but for 
            all the elements we come across we've filled the minheap w
            k elements already, if the currenet element is larger than
            the min (root), then we replace it with the current element
            e.g, if we want 3rd largest in [1 2 3 4 5], we would add
            1 2 3 initiallt. then, replace 1 with 4 and then 2 with 5.
            so, at the end we retuen 3. 

            time: O(nlogk), space: O(k)
        - quickselect

            time: O(n) avg but O(n^2) worst, space: O(1)

    tests
        - regular
        - k is largest
        - k is smallet
        - one element array
     */ 

     public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            if(minHeap.size() < k){
                minHeap.add(num);
            }else{
                if(num > minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(num);
                }
            }
        }

        return minHeap.peek();
    }
}