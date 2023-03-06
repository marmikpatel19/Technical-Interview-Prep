class SearchInsertPosition {
    // time: O(log(n)), space: O(1)
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        // binary search to find the index of target
        while (start <= end) {
            int mid = (start + end) / 2;

            if (target == nums[mid])
                return mid;
            else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}