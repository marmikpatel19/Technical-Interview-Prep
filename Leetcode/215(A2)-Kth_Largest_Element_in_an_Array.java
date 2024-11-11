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
            - quickselect is for kth smallest, so we need to do n - k.
            - see technical notes doc for notes on implementation 

            time: O(n) avg but O(n^2) worst, space: O(1)

    tests
        - regular
        - k is largest
        - k is smallet
        - one element array
     */ 

     public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, k, 0, nums.length);
    }

    private int quickSelect(int[] nums, int k, int l, int r){
        int pivotValue = nums[r - 1];
        int pivotIndex = l;

        for(int i = l; i < r - 1; i++){
            if(nums[i] <= pivotValue){
                int temp = nums[i];
                nums[i] = nums[pivotIndex];
                nums[pivotIndex] = temp;

                pivotIndex++;
            }
        }

        // swap pivotIndex and pivotValue
        nums[r - 1] = nums[pivotIndex];
        nums[pivotIndex] = pivotValue;

        // recurse
        if(pivotIndex == k){return nums[pivotIndex];}
        else if(k < pivotIndex){
            return quickSelect(nums, k, l, pivotIndex);
        }else{
            return quickSelect(nums, k, pivotIndex + 1, r);
        }
    }
}