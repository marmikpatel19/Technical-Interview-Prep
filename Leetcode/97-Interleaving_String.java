class InterleavingString {
    /**
    2D DP.

    This is a subproblem question because index i in s3 can be made if
    s3[i] can be made using one of the two strings and s3[i + 1] can
    be made. 

    We can used a 2D boolean array as a memo. Each index (i, j) represents
    whether the index s3[i + j] is possible given the char at s1[i] and
    s2[j]. The intuition comes from the fact that the position of each 
    pointer traversing s2 and s2 can be used as a coordinate pair. For
    example for s1 = "abc", s2 = "cvd", s3 = "abccvd", (2,1) is true
    if position two in s2 (c) and position one in s3 (c) can be used
    to make position (2 + 1 = ) 3 in s3 (c).

    The base case becomes (s1.length(), s2.length())--the out-of-bounds
    indices for each string. This has to be true because the 
    out-of-bounds char in s3 can be made from the out-of-bounds chars
    in s1 and s2. 

    The corresponding rows where *one* of the strings is out-of-bounds
    represent the case where that string has ended and the other
    string has not. 

    A given index is true if the either of the current chars at s1 and s2
    can be used to make the current char in s3[i + j] and the opposite char
    from s1 or s2 in either dp(i + 1, j) or dp(i, j + 1) is true, 
    representing that the subproblem s3[i + j + 1] is valid. We do 
    opposite because if s1(i) matches, then we cannot check the adjacent
    entry where the same char was used again.
    */

    // time: O(nm), space: O(nm)
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        
        if(n + m != s3.length()){return false;}

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[n][m] = true; // base case

        for(int r = n; r >= 0; r--){
            for(int c = m; c >= 0; c--){
                if(r + c != n + m){ // base case already completed
                    if(r < n && s3.charAt(r + c) == s1.charAt(r) 
                    && r + 1 <= n && dp[r + 1][c] == true){
                        dp[r][c] = true;
                    }
                    else if(c < m && s3.charAt(r + c) == s2.charAt(c)
                    && c + 1 <= m && dp[r][c + 1] == true ){
                        dp[r][c] = true;
                    } 
                }
            }
        }

        return dp[0][0];
    }
}