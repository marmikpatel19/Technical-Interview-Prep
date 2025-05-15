class BestTimetoBuyandSellStockA3 {
    /**
    clarifying questions:
        - days are sequental?
        - values are all positive?
        - buy must come before selling right? 
        - what if we cannot achieve profits? return 0? 
        - prices min length? 
    
    approaches
        - brute force: find every combination and return the largest one: O(N^2)
        - two-pointer. iterate r. iterate l if curr is < l. calculate diff if l!=r
        and store max diff. O(n), O(1)
    */
    public int maxProfit(int[] prices) {
        if(prices.length == 1){return 0;}

      int l = 0;
      int maxProfit = 0;

      for(int r = 1; r < prices.length; r++){
        if(prices[r] < prices[l]){
          l = r;
        }

        if(l != r && prices[r] > prices[l]){
          maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
        }
      }

      return maxProfit;
    }
}