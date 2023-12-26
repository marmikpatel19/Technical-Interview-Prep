class FindMinimuminRotatedSortedArray {
    /** sorted array => binary search 
    
    Regular binary search except since it's rotated, we do a 
    comparision between the value at midpoint and the value
    at either one of the ends (l or r). This covers both
    cases:
    1) unrotated:
        nums[r] > nums[mid] so we know to go left
    2) rotated:
        nums[r] < nums[mid] so we know to right

        This is always true because a rotation rightward 
        (until midpoint) (e.g., [1 2 3 4] --> [4 1 2 3]) 
        means that nums[r] > nums[mid] so we know to go left

        And a rotation leftward (until midpoint) (e.g., 
        [1 2 3 4] --> [2 3 4 1]) means that  nums[r] < nums[mid] 
        so we know to right
    */

    // time: O(log(n)), space: O(1)
    public int findMin(int[] nums) {
        if(nums.length == 1){return nums[0];}

        int l = 0;
        int r = nums.length;

        while(r - l > 2){
            int midIndex = l + ((r - l) / 2);

            // go left
            if(nums[r - 1] > nums[midIndex]){
                r = midIndex + 1;
            }
            // go right 
            else{
                l = midIndex;
            }
        }

        return Math.min(nums[l], nums[l + 1]);
    }
}