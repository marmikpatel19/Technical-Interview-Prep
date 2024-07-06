class JumpGame {
    /**
    Greedy.

    Iterate backwards. given a set of indices which successfully lead to the last index, 
    the only relevant one is the leftmost one b/c if it can past, then it defintively
    can hit the lowest one.

    Iterate backwards; at each index greedily decide whether the current index can jump
    to the left-most target. 
     */

    // time: O(n), space: O(1)
    public boolean canJump(int[] nums) {
        int lowestReachableTargetIndex = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] + i >= lowestReachableTargetIndex){
                lowestReachableTargetIndex = i;
            }
        }
        
        if(lowestReachableTargetIndex == 0){return true;}
        return false;
    }
}