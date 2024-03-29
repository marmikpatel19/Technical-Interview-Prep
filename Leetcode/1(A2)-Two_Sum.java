class TwoSumA2 {
    // time: O(n), space: O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsToIndex = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            numsToIndex.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            if(numsToIndex.containsKey(target - nums[i]) && numsToIndex.get(target - nums[i]) != i){
                return new int[] {i, numsToIndex.get(target - nums[i])};
            }
        }

        return new int[2];
    }
}