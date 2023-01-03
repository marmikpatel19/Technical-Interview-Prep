class ClimbingStairs {
    /*
     * The current number of steps is the number of sets at (n - 1) + (n - 2)
     * 
     * DP with tabulation is used
     */

    // time: O(n), space: O(1)
    public int climbStairs(int n) {
        // edge cases
        if (n == 1 || n == 2) {
            return n;
        }

        // define tabulation variables, initializing them to base cases
        // edge cases 0 and 1 are covered above, so the base case we start with is n =
        // 3, for which
        // the output at n - 1 is 2 and n - 2 is 1.
        int one_step_before = 2;
        int two_steps_before = 1;

        int total = 0;

        // iterate bottom-up
        for (int i = 3; i <= n; i++) {
            total = one_step_before + two_steps_before;

            // update variables
            two_steps_before = one_step_before;
            one_step_before = total;
        }

        return total;
    }
}