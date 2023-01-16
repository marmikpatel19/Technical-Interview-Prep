class BestTimetoBuyandSellStock {
    // time: O(n), space: O(1)
    public int maxProfit(int[] prices) {
        int currentMax = 0;
        int currentMin = prices[0];

        // traverse through all profits
        for (int i = 0; i < prices.length; i++) {
            // update currentMin
            if (prices[i] < currentMin) {
                currentMin = prices[i];
            }

            // update currentMax
            if (prices[i] - currentMin > currentMax) {
                currentMax = prices[i] - currentMin;
            }
        }

        return currentMax;
    }
}