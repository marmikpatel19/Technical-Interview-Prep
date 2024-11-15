class MergeSortedArray(A2) {
    /**
    Clairicatiions
        - empty array --> doesn't matter then
        - can I assume nums1 length is always m + n?
        - nums1 and nums2 are sorted

    approaches
        - create new list, iterate through nums1 and nums2 and store
            all the numbers into the list. sort the list. and then
            add those numbers back to nums1
            T(N): O(mnlog(nm)), S(N): O(NM)
        - backward iteration with greedy selection
            T(N): O(mn), space: O(1)

    tests
        - regular
        - smaller or greater nums in comparison
        - empty array (size 0)
        - single element array 
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){return;}

        int p = m + n - 1;
        m--;
        n--;

        while(m >= 0 && n >= 0 && p >= 0){
            if(nums1[m] > nums2[n]){
                nums1[p] = nums1[m];
                m--;
                p--;
            }else{
                nums1[p] = nums2[n];
                n--;
                p--;
            }
        }

        if(m == -1 && n >= 0 && p >= 0){
            while(n >= 0 && p >= 0){
                nums1[p] = nums2[n];
                n--;
                p--;
            }
        }
    }
}