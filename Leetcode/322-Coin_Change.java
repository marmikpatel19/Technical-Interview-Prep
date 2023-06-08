class CoinChange{
    // "fewest" => optimization
    // greedy fails. Counterexample: [1, 3, 4, 5], 7. Greedy would produce 3 (5 + 1 + 1) instead of 2 (3 + 4)
    // Therefore, it's a DP questions

    /* Do bottom-up DP where bottom defines the lowest number and we work ourselves up. 
    Memoize the count at each number.

    Initialize the memo to be amount + 1 to be able to tell at the end if the combination could is not 
    possible. 

    For each number from 0 to amount, iterate through each coin and check if it can be used to sum up
    to the given number. If so, associate it's memo to be the minimum of the memo of itself minus the current
    coin, plus 1. Do this until making it to the top.

    e.g., [1, 3, 4, 5], 7

    memo[0] = 0
    memo[1] = 1 (one 1)
    memo[2] = 2 (two 1s)
    memo[3] = 1 (one 3)
    memo[4] = 1 (one 4)
    memo[5] = 2 (one 4, one 1)
    memo[6] = 2 (one 5, one 1)
    memo[7] = 2 (one 4, one 4)
     
    e.g., Example 2

    memo[0] = 0
    memo[1] = 4
    memo[2] = 1
    memo[3] = min(4, memo[1] + 1 = 5) = 4
    
    e.g., Example 3

    memo[0] = 0             
    */

    // time: O(amount * n), space: O(amount), n is coins.length
    public int coinChange(int[] coins, int amount) {
        // stores count of coins needed for each number from 0-amount, inclusive
        int[] memo = new int[amount + 1];
        java.util.Arrays.fill(memo, amount + 1);

        // memoize count for each number, until reaching amount
        memo[0] = 0; // base case
        for(int num = 1; num <= amount; num++){
            // consider each coin
            for(int j = 0; j < coins.length; j++){
                if(num - coins[j] >= 0){
                    memo[num] = Math.min(memo[num], memo[num - coins[j]] + 1);  
                }
            }
        }

        if(memo[amount] == amount + 1){
            return -1;
        }
        else{
            return memo[amount];
        }
    }
}