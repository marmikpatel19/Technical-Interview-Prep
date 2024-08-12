class RemoveOneElementtoMaketheArrayStrictlyIncreasing {
    /** Iterate throguh array and check each index element with the
    previous one for strictly increase.

    If fails, we actually need to check two cases:
        - removing current num: e.g., 2 in [1, 4, 5, 2, 6]
        - removing previous num: e.g., 5 in [1, 2, 5, 3, 5]
    
    If either of these fixes work, then it's a single replacement.
    But if both fail, then there has to be > one replacement => return false
     */

     // time: O(n), spaceL O(1)
     public boolean canBeIncreasing(int[] nums) {
        if(nums.length < 2){
            return true;
        }
        int numRemovals = 0;
        
        // edge case: first index
        if(nums[0] >= nums[1]){
            numRemovals++;
        }
        
        for(int i = 2; i < nums.length; i++){
            if(nums[i - 1] >= nums[i]){
                numRemovals++;
                if(numRemovals > 1 || i + 1 < nums.length && nums[i - 1] 
                >= nums[i + 1] && nums[i - 2] >= nums[i]){return false;}
            }
        }

        return numRemovals <= 1;
    }
}