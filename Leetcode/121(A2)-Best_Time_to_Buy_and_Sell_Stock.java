class BestTimetoBuyandSellStockA2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0;
        int r = 0;

        while(r < prices.length){
            maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            
            if(prices[r] < prices[l]){
                l = r;
            }

            r++;
        }

        return maxProfit;
    }
}