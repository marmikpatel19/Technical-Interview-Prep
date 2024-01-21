class HouseRobberII {
    /* same bottom-up memoized, DP at House Robber I, except the first
    and last houses cannot be adjacent. A different way of understanding this
    is that we want the max of [1, ..., n - 1] and [2, ..., n].
    */

    // time: O(n), space: O(n)
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){return nums[0];}
        else if(n == 2){return Math.max(nums[0], nums[1]);}
        return Math.max(helper(java.util.Arrays.copyOfRange(nums, 0, n - 1)), helper(java.util.Arrays.copyOfRange(nums, 1, n)));
    }

    private int helper(int[] nums){
        int n = nums.length;
        if(n == 1){return nums[0];}
        else if(n == 2){return Math.max(nums[0], nums[1]);}
        nums[n - 2] = Math.max(nums[n - 2], nums[n - 1]);

        for(int i = n - 3; i >= 0; i--){
            nums[i] = Math.max(nums[i] + nums[i + 2], nums[i + 1]);
        }

        return nums[0];
    }
}