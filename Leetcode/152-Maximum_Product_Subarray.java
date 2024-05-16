class MaximumProductSubarray {
    /** 
    DP for O(n) because brute force is O(n^2)

    We maintain an ongoing tally of the largest product thus fas as we iterate. This automatically
    encapsulates the concept of subarrays because if the product x the current element < the current
    element itself, then we update the product to just the current element. So, at all times, we have 
    the largest product thus far in the iteration.

    We also have to consider the negative case where the largest positive max doesn't count it. e.g.,
    [-3, -5]. Just curPositiveMax alone would give the answer -3, though the real answer is 15. So,
    we maintain the currentNegativeMax as well.

    At each iteration, find the largest positive and negative values by comparing the current number, 
    the current number times the current positive max, and the current number times the current negative
    max (in the case it produces a largest positive).

    Maintain a total max variable to since the other two variables only focus on the maxes in the current
    subarray
     */

    // time: O(n), space: O(1)
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currMaxPositive = nums[0];
        int currMaxNegative = nums[0];

        for(int i = 1; i < nums.length; i++){ 
            int tempMax = currMaxPositive;
            tempMax = Math.max(nums[i], Math.max(nums[i] * currMaxPositive, nums[i] * currMaxNegative));
            currMaxNegative = Math.min(nums[i], Math.min(nums[i] * currMaxPositive, nums[i] * currMaxNegative));
            currMaxPositive = tempMax;
            
            max = Math.max(max, currMaxPositive);
        }

        return max;
    }
}