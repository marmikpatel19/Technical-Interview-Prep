class MaximumProductofThreeNumbers {
    // time: O(nlogn), space: O(1)
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int negSum = nums[0] * nums[1] * nums[2];
        int posSum = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int twoNegSum = nums[0] * nums[1] * nums[n - 1];

        return Math.max(negSum, Math.max(posSum, twoNegSum));
    }
}