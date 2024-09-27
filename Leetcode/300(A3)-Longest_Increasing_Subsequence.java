class LongestIncreasingSubsequence {
    /** DP

    Iterate through the array. At each index, memoize the LIS *that includes* the current 
    num. Do this by comparing current num with all past nums in the array; if curr num
    is bigger, update it's memo with comparative num memo + 1.

    Maintain currMax term to retuern at the end;

    e.g.,
    nums: [10,9,2,5,3,7,101,18]
    memo: [1,1, 1,2,2,3, 4, 4]

    e.g.,
    nums: [0,1,0,3,2,3]
    memo: [1,2,1,3,3,4]

    e.g.,
    nums: [4,10,4,3,8,9]
    memo: [1,2, 1,1,2,3]
     */
    
    // time: O(n^2), space: O(n)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int max = 1;

        // initialize memo
        int[] memo = new int[n];        
        Arrays.fill(memo, 1);
        
        for(int i = 0; i < n; i++){
            int currMax = 1;

            // compare curr num to all past ones
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    currMax = Math.max(currMax, memo[j] + 1);
                }
            }

            memo[i] = currMax;
            max = Math.max(max, currMax);
        }

        return max;
    }
}
