class WordBreak {
    /* This can be solved with a sub-problem structure => DP

    Bottom-up memoization.

    Start at the end of the array and work backwards. At each index, memoize whether a 
    word in the dictionary matches (true or false). It does not need to match entirely from i to n--it
    can match a part of the word
     */

    // time: O(n^2*m), space: O(n), where n s.length() and m is wordDict.size()
    // The second n comes from string comparison, which is O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        // buttom-up iteration throgh every index; check if a word matches
        for(int i = n - 1; i >= 0; i--){
            for(String word : wordDict){
                if(i + word.length() <= n && (s.substring(i, i  + word.length())).equals(word)){
                    // this allows us to enure that word break is true at the current index. i.e., are
                    // there enough matching words to allow us to get to the end of the string from the
                    // current index
                    dp[i] = dp[i + word.length()];
                    
                    // prevent additional loops which may ovewrite a true dp[i] to false
                    if(dp[i]){break;}
                }
            }
            // dp[i] is false otherwise; dp[] at each index is false by defualt during initiailziation
        }

        return dp[0];
    }
}