class HouseRobberA2 {
    /** Bottom up (bottom = end of array) DP (aub problem question)
    At each index store the max up to that point. 
     */

     // time: O(n), space: O(1)
     public int rob(int[] nums) {
        int n = nums.length; 
        if(n == 1){return nums[0];}
        else if(n == 2){return Math.max(nums[0], nums[1]);}
        nums[n - 2] = Math.max(nums[n - 2], nums[n - 1]);

        for(int i = nums.length - 3; i >= 0; i--){
            nums[i] = Math.max(nums[i] + nums[i + 2], nums[i + 1]);
        }

        return nums[0];
    }
}