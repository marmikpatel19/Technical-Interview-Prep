class SearchinRotatedSortedArray {
    // Time: O(log(n)), space: O(1)
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        // find the unrotated starting index
        while (start < end) {
            int mid = (end + start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        int rotatedStart = start;
        start = 0;
        end = n - 1;

        // binary search for target's index
        while (start <= end) {
            int mid = (end + start) / 2;
            int rotatedMid = (mid + rotatedStart) % n;

            if (target == nums[rotatedMid]) {
                return rotatedMid;
            }
            if (target > nums[rotatedMid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}