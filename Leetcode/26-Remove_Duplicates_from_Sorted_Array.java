class RemoveDuplicatesfromSortedArray {
    // time: O(n), space: O(1)
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;

        while(j < nums.length){
            if(nums[j] == nums[i]){
                j++;
            }
            else{
                i++;
                nums[i] = nums[j];
                j++;
            }
        }

        return i + 1;
    }
}