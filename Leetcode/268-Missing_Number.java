class MissingNumber {
    // time: O(nlogn), space: O(1)
    public int missingNumber(int[] nums) {
        java.util.Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }

        return nums.length;
    }
}