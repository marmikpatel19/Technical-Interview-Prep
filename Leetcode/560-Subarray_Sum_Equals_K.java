class SubarraySumEqualsK {
    /**
    clarirvciations
        - just the num not the subarrays themsebvles
        - nums empty => return 0
        - subarray --> continugious
        - nums can eppositive an dnegativbe right
        
    approaches
        - find every subarray and check if it == k
            T: O(N^2)

        - sliding window 
            does not work! only works for positive nums

        - prefix sum
            if sum[i] - k is a cumulative sum we've seen
            previously, say at index j, then between i and j
            there is a subarray that equals k!

            put all cumulative sums in a hashmap: sum->number of occurences

            at each index i, check if map contains sum[i] - k. if it does,
            subarray found and do --. at each index also put into map

            T: O(N), S: O(1)

    tests
        - regular
        - no matches
        - k = less than all nums,
        - num[i] == k
     */

     public int subarraySum(int[] nums, int k) {
        if(nums.length == 0){return 0;}

        int prefixSum = 0;
        HashMap<Integer, Integer> numToFreq = new HashMap<>();
        int numMatches = 0;
        numToFreq.put(0, 1); // handles the first time we come across nums[i] == k

        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i]; // the subarray formed from i to all prev ones are all valid

            if(numToFreq.containsKey(prefixSum - k)){
                numMatches+= numToFreq.get(prefixSum - k);
            }

            numToFreq.put(prefixSum, numToFreq.getOrDefault(prefixSum, 0) + 1);
        }

        return numMatches;
    }
}