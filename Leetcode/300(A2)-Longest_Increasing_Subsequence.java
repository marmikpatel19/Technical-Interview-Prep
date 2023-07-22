class LongestIncreasingSubsequence {
    // longest --> optimization

    /*
     * 2-D DP with memoization bottom-up, where bottom is the end of the array. The
     * length of* the LIS at each index is memoized by traversing through all the
     * memos
     * that come before it
     */

    /*
     * e.g., [10,9,2,5,3,7,101,18]
     * LISs: [[10, 101],[9, 101],[2, 5, 7, 101],[5, 7, 101],[3, 7, 101],[7,
     * 101],[101],[18]]
     * memo: [2, 2, 4, 3, 3, 2, 1, 1]
     */

    /*
     * e.g., [0,1,0,3,2,3]
     * LISs: [[0, 1, 2, 3],[1, 2, 3],[0, 2, 3],[3],[2, 3],[3]]
     * memo:[4, 3, 1, 2, 1]
     */

    // time: O(n^2), space: O(n)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int largestLength = 1;
        int[] memo = new int[n];
        memo[n - 1] = 1;

        if (n == 1) {
            return 1;
        }
        ;

        // find the LIS at each index bottom-up
        for (int i = n - 2; i >= 0; i--) {
            int currLargestLength = 1;
            int currNum = nums[i];

            for (int j = i + 1; j < n; j++) {
                if (currNum < nums[j]) {
                    currLargestLength = Math.max(currLargestLength, memo[j] + 1);
                }
            }

            memo[i] = currLargestLength;
            largestLength = Math.max(largestLength, memo[i]);
        }

        return largestLength;
    }
}
