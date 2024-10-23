class EditDistance {
     /** DP

    Draw it out! going from horse to ros. expand on each possibility (insert, delete, substitude)

    use a memo to prevent repetitive calculations. the size of the memo is the size of each
    string. the value of memo[i][j] is the min cost required to conver the s1 from i to its end
    to s2 from j to its end--we are converting the strings backwards! eventually, we return
    memo[0, 0];

    But don't be confused: we start at index i = 0 and j = 0 and iterate through the arrays.
    We just keep recursively calling with incremented is and js. that's why memo[i][j] 
    represents the remainder of the calculations

    Bases cases:
        if either if the string is complete, then we simply return the lenght of the other one
        (this represents inserting that many times)

        if we've found the current calculation already (memo), then return that;
    
    recursive calls
        if the characters match, recurse with increment i and j

        call insert, delete, sub, and store & return the minimum.
        insert: if we insert a char from s2 into s1, then we've already covered 
            that s2 char, so we increment j.
        delete: if we delete char in s1, then we increment i.
        sub: if we sub char from s2 to s1, we increment both 
    */

    // time: O(mn), space: O(mn)
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }

        return dp(word1, word2, 0, 0, memo);
    }

    private int dp(String word1, String word2, int i, int j, int[][] memo){
        // base cases
        if(i >= word1.length()){
            return  word2.length() - j;
        }
        if(j >= word2.length()){
            return word1.length() - i;
        }
        if(memo[i][j] != -1){return memo[i][j];}

        // recursive calls
        if(word1.charAt(i) == word2.charAt(j)){
            memo[i][j] = dp(word1, word2, i + 1, j + 1, memo);
            return memo[i][j];
        }
        int insert = dp(word1, word2, i, j + 1, memo) + 1;
        int delete = dp(word1, word2, i + 1, j, memo) + 1;
        int sub = dp(word1, word2, i + 1, j + 1, memo) + 1;
        memo[i][j] = Math.min(insert, Math.min(delete, sub));
        return memo[i][j];
    }
}