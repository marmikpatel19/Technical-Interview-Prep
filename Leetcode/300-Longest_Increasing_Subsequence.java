class LongestIncreasingSubsequence {
    // DP with memonization
    // The *length of* LIS at each index is memoized
    // Dispite this being memoization, we start bottom-up, where the base-case
    // is the last index, since that is gaurenteed to have a LIS of length 1.

    // time: O(n^2), space: O(1)
    public int lengthOfLIS(int[] nums) {
        int[] LISs = new int[nums.length]; // memo of length of LIS at each index
        int maxLength = 1;

        // initialize base case
        LISs[nums.length - 1] = 1;

        // iterate through each element starting with the base case of the last index
        for (int i = nums.length - 2; i >= 0; i--) {
            int curMax = 1; // 1 because any index on its own has a LIS of one

            // iterate through all following elements to find the lengths of the LISs for
            // current DP case
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    curMax = Math.max(curMax, 1 + LISs[j]);
                }
            }

            LISs[i] = curMax;
            maxLength = Math.max(maxLength, curMax);
        }

        return maxLength;
    }
}