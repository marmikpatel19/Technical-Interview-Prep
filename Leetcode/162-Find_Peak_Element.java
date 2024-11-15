class FindPeakElement {
    /**
    clarifications
        - what if the element is the start or end of the array --> do we assume >
        - array can contain multiple peaks--which do I return in that case? 
        - can we assume array has at least one element, in wchihc casre reutnr that? 
        - return index not element 
        - can we gaurentee that a nieghtbour is not the same as its element, like
            two elements are not the same consecutively
    
    approaches
        - iterate throuigh the array and check for each index if it's greater than neighbors
            T(N): O(N), space: O(1)
        - BS
            - if the curretr element is peak (both l and r are < curr), return
            - otherwise one (or both) of l and r must be > curr.
                We know that the outside (indicies -1 and n) are lower bounds.
                therefore, if nieghbour is greater than curr and must be 
                greater than inifnite, then there must be at least one peak
                on that half of the array, and we can iterate there. 
            T(N): O(logn), S(N): O(1)
    tests
        - odd case, even case
        - peak at one of the borders
        - single element array
        - peak in the middle
     */
    public int findPeakElement(int[] nums) {
        int n = nums.length; 
        int l = 0;
        int r = n - 1;

        while(l < r){
            int mid = (l + r) / 2;
            int midValue = nums[mid];
            int leftValue = mid - 1 == -1 ? Integer.MIN_VALUE : nums[mid - 1];
            int rightValue = mid + 1 == n ? Integer.MIN_VALUE : nums[mid + 1];

            if(midValue > leftValue && midValue > rightValue){return mid;}
            else if(rightValue > midValue){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return l;
    }
}