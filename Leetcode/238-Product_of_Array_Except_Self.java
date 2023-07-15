class ProductofArrayExceptSelf {
    /*
     * The concept is that the product at a given index is the product of all its
     * prefixes and
     * all its suffixes. E.g., in [1, 2, 3, 4], the product at index 2 is the
     * product of 1 x 2 = 2 and 4,
     * which is 8.
     * 
     * We can leverage this technique by calculating all the prefixes and suffixes.
     * 
     * We can minize space complexity by reusing the output array
     */

    // Time: O(n), space: O(1)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // calculate all prefixes
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            output[i] = prefix;

            prefix *= nums[i];
        }

        // calculate all suffixes
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= suffix;

            suffix *= nums[i];
        }

        return output;
    }
}