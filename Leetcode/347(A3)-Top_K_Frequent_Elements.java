class TopKFrequentElementsA2 {
    /**
    Clarifications
        - list of k most freq and not kth element, right?
        - return in any order?
        - at least one element in the array? 
        - assume k is valid?

    approaches
        - FreqHashSet. create tuple for num->freq. sort it by freq. 
        create list of top k most freq and return that. 
            time: n + nlogn + k space: n + n + k
        
        - hashSet. create tuple for num->freq. MinHeap, store the k largest
        elements. return all those elements
            time: n + nlogk, space: n + k
        
        - quickselect. partition the array via a pivot as we iterate and return 
        the elements kth position to the end. compare using freq. return subarray 
        form k to end. We also need to pass in a new array w just the unique nums.
            time: avg: O(n), worst: O(N^2). space: avg: O(1), worst O(n)

    tests 
        - regular test case
        - both heap arranging and not arranging

    [1 1 1 2 2 3], k = 2
    (1 -> 3, 3 -> 1, 2 -> 2, )
    MinHeap: (1|3, 2|1)
     */

     public int[] topKFrequent(int[] nums, int k) {
        // create freq hashset
        HashMap<Integer, Integer> numToFreq = new HashMap<>();
        for(int num : nums){
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }

        // create new array w only unqiue numbers
        int[] uniqueNums = new int[numToFreq.size()];
        int j = 0;
        for(int num : numToFreq.keySet()){
            uniqueNums[j] = num;
            j++;
        }
        int kIndex = uniqueNums.length - k;

        quickSelect(uniqueNums, kIndex, 0, uniqueNums.length, numToFreq);

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = uniqueNums[i + kIndex];
        }

        return res;
    }

    private void quickSelect(int[] nums, int k, int l, int r, HashMap<Integer, Integer> numToFreq){
        int pivotValue = numToFreq.get(nums[r - 1]);
        int pivotIndex = l;

        for(int i = l; i < r - 1; i++){
            if(numToFreq.get(nums[i]) <= pivotValue){
                int temp = nums[i];
                nums[i] = nums[pivotIndex];
                nums[pivotIndex] = temp;

                pivotIndex++;
            } 
        }

        int temp = nums[r - 1];
        nums[r - 1] = nums[pivotIndex];
        nums[pivotIndex] = temp;

        if(pivotIndex == k){
            return;
        }else if(k < pivotIndex){
            quickSelect(nums, k, l, pivotIndex, numToFreq);
        }else{
            quickSelect(nums, k, pivotIndex + 1, r, numToFreq);
        }
    }
}