class CountingBits {
    /*
     * Brute force solution: repeated mod and divide by two. The mod gives us
     * whether there is a one in the rightmost digit. The division by two shifts
     * right by one decimal place. This is O(nlog(n)) because the repeated devision
     * by two is log(n).
     * 
     * O(n) solution: DP with a memo
     * The subproblem comes from the idea that a given number is composed of the
     * numbers that came before it.
     * For example, five (101) is 1 in the third digit plus one (01). This is useful
     * for counting the number of
     * one'--the first one can be counted and then the remainder ones can be found
     * in the memo. In other words,
     * we do 1 + dp[current number - offset], where offset is the current largest
     * bit
     * 
     * e.g.,
     * four (100) = 1 + dp[4 - 4] = 1 + 0 = 1
     * five (101) = 1 + dp[5 - 4] = 1 + 1 = 2
     * six (110) = 1 + dp[6 - 4] = 1 + 1 = 2
     * seven (111) = 1 + dp[7 - 4] = 1 + 2 = 3
     * eight (1000) = 1 + dp[8 - 8] = 1 + 0 = 0
     */

    // time: O(n), space: O(n)
    public int[] countBits(int n) {
        int[] memo = new int[n + 1];

        // base cases
        if (n == 0) {
            return new int[] { 0 };
        }
        if (n == 1) {
            return new int[] { 0, 1 };
        }
        memo[0] = 0;
        memo[1] = 1;

        int offset = 2;

        // calculate remaining numbers using memo
        for (int i = 2; i < n + 1; i++) {
            // update offset to the largest current bit
            if (i == offset * 2) {
                offset *= 2;
            }

            memo[i] = 1 + memo[i - offset];
        }

        return memo;
    }
}