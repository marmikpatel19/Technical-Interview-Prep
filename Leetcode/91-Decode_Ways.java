class DecodeWays {
    /**
    Typical bottom-up DP with memo.

    Use memo to store the number of decodings at each index (subproblems), working your from the end of the array 
    to the beginning. Thus, memo[0] gives the number of decodings of s.

    The number of decodings at a given index i (memo[i]) is the sum of the number of decodings at 
    memo[i + 1] if the current char is valid and the number of decodings at memo[i + 2] if the current
    two chars are valid. 

    For the two char check, if the length of the string itself is two, then we address that edge case
    by simply adding one and not querying memo[i + 2]
     */

    // time: O(n), space: O(n)
    public int numDecodings(String s) {
        int[] memo = new int[s.length()]; // memo[i] represents the number of decoding formed by string at i
        memo[s.length() - 1] = isValid(String.valueOf(s.charAt(s.length() - 1))) ? 1 : 0; // base case

        // iterate bottom up
        for(int i = s.length() - 2; i > -1; i--){            
            if(isValid(String.valueOf(s.charAt(i)))){memo[i] += memo[i + 1];}
            if(i + 2 <= s.length() && isValid(s.substring(i, i + 2))){
                memo[i] = i + 2 == s.length() ? memo[i] + 1 : memo[i] + memo[i + 2]; 
            }
        }

        return memo[0];
    }

    private boolean isValid(String s){
        if(s.length() == 2 && s.charAt(0) == '0'){return false;}

        int num = Integer.valueOf(s);
        if(num > 0 && num < 27){
            return true;
        }
        else{return false;}
    }
}