class TwoSumA3 {
    /**
    Iterate through the array; map each num to the index at which it appears.
    In the case of duplicate numbers, the end-most appearing instance of that
    number will be stores as it will be overwritten in the hashmap.

    iterate through nums. at each index, check if the reciprocal (target - num)
    exists in the hashmap. if it does, return the two indicies.
     */
    
    // time: O(n), space: O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            numToIndex.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            if(numToIndex.containsKey(target - nums[i]) &&
                numToIndex.get(target - nums[i]) != i){
                return new int[] {i, numToIndex.get(target - nums[i])};
            }
        }

        return new int[2];
    }
}