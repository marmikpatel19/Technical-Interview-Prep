import java.util.Arrays;

class HouseRobber {
    // the cumulative sum
    private int[] memo;

    // time: O(n), space O(n)
    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }

    /*
     * i is the current index
     */
    private int rob(int[] nums, int i) {
        // edge cases
        if (i < 0) {
            return 0;
        }

        // if memo[i] has been initialized, return that cumulative sum
        if (memo[i] >= 0) {
            return memo[i];
        } else {
            /*
             * A robber has two options:
             * 1) rob current house
             * this means that the previously robbed house is i - 2
             * 2) don't rob current house
             * this means that the previously robbed house is i - 1
             * The robber seeks the more lucrative option
             */
            int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));

            // update memo[i]
            memo[i] = result;
            return result;
        }

    }
}