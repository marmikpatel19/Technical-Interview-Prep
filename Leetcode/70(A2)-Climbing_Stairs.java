class ClimbingStairsA2 {
    /**
    Bottom-up, tabulation DP.

    This is fibonacci. We implement it by having two points, one for each number that we are adding
    to get the current number. We use these variables to implement this using tabulation in O(1)
    rather than memoization in O(n)
     */

    // time: O(n), space: O(1)

    public int climbStairs(int n) {
        if(n == 1 || n == 2){
            return n;
        }

        int two_steps_ahead = 1;
        int one_step_ahead = 1;

        for(int i = 3; i <= n; i++){
            int temp = two_steps_ahead;
            two_steps_ahead = two_steps_ahead + one_step_ahead;
            one_step_ahead = temp;
        }

        return two_steps_ahead + one_step_ahead; 
    }
}