class LongestCommonSubsequence {
    // "longest" => optimization => DP

    /*
     * we can aim for a similar optimization as #300, where we don't need to
     * store subsequneces, but insteads just the lengths
     * 
     * Memoize the *length of* the longest common subsequence at each index for each
     * string in the 2-D memo. We use a 2-D array because we're comparing two items.
     * Start bottom up, where the bottom is end of both strings. Do a
     * brute-force-like approach where we calculate the LCS at each index starting
     * from the ends the strings. If characters match at a given index during
     * traversal, the value at that index the value at the next diagonal index + 1
     * (because the diagonals represents both strings together). If the current
     * characters do not match, the value at that index is the max of the values at
     * the index down or to the right.
     */

    /*
     * E.g.,
     * text1 = "abcde", text2 = "ace"
     * memo =
     * -- a c e
     * a [3, 2, 1]
     * b [2, 2, 1]
     * c [2, 2, 1]
     * d [1, 1, 1]
     * e [1, 1, 1]
     */

    /*
     * E.g.,
     * text1 = "abc", text2 = "ccbbaa"
     * memo =
     * -- c c b b a a
     * a [1, 1, 1, 1, 1, 1]
     * b [1, 1, 1, 1, 0, 0]
     * c [1, 1, 0, 0, 0, 0]
     */

    // time: O(n * m), space: O(n * m)
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] memo = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int down = i + 1 >= n ? 0 : memo[i + 1][j];
                int right = j + 1 >= m ? 0 : memo[i][j + 1];

                // we add + 1 to the length of the LCS stored at the diagonal
                // because the diagonal represents the actual LCS string
                if (text1.charAt(i) == text2.charAt(j)) {
                    memo[i][j] = i + 1 >= n || j + 1 >= m ? 1 : memo[i + 1][j + 1] + 1;
                } else {
                    memo[i][j] = Math.max(down, right);
                }
            }
        }

        return memo[0][0];
    }
}