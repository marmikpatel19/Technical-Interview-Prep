class BestTimetoBuyandSellStockwithCooldown {
    /** DP with memo, but memo is complex.

    At each index, we have three actions: buy, sell, or hold (do neither).
    But the state we can store is canBuy (true or false, where false
    is sell) b/c hold simplying skips an index but the state
    stays the same (e.g., at index i if we're in a canBuy state, we can
    either buy or increment the index to i + 1 where we're still in
    a canBuy state).

    The memo thus stores up to two sets of keys for each index, 
    one for canBuy or one for !canBuy (sell). I say "up to" b/c in some
    instances we may not be able to buy or sell. 

    Out of the calls we are able to make (buy/sell/hold), at the 
    given index in the dp, we store the one with max profit. i.e.,
    the value we store in the dp is the max profit to date.

    Our key then is a tuple, (i, canBuy), and the value is maxProfit.

    When determining the max profit of the current index, if selling
    then add prices[i] to the ongoing call (sold => profit); if 
    buying then subtract prices[i] to the ongoing call (buy =>
    loss). 

    e.g.,
        prices = [1, 2, 3, 0, 2]

        maxprofit: recurse w index 0, state canBuy (cannot sell first):
            maxprofit: Max(buy & recurse w index 1 & state sell, 
            recurse w index 1 and state canBuy)
                maxprofit: Max(sell & recurse w index *3*, recurse 
                w index 2 and state sell) 
                    ...

                maxProfit: Max(recurse w index 2 & state sell, 
                recurse w index 2 and state canBuy)
                    ...
     */

    // time: O(n), space: O(n) 
    public int maxProfit(int[] prices) {
        HashMap<Pair<Integer, Boolean>, Integer> stateAndIndexToMaxProfit = new HashMap<>(); 
        Pair<Integer, Boolean> currIndexAndCanBuy = new Pair(0, true);
        return calculateMaxProfit(prices, currIndexAndCanBuy, stateAndIndexToMaxProfit);
    }

    private int calculateMaxProfit(int[] prices, Pair<Integer, Boolean> currIndexAndCanBuy, 
    HashMap<Pair<Integer, Boolean>, Integer> stateAndIndexToMaxProfit){
        if(currIndexAndCanBuy.getKey() >= prices.length){return 0;}
        if(stateAndIndexToMaxProfit.containsKey(currIndexAndCanBuy)){return 
        stateAndIndexToMaxProfit.get(currIndexAndCanBuy);}

        if(currIndexAndCanBuy.getValue() == true){ // canBuy
            Pair<Integer, Boolean> purchasedKey = new Pair<>(currIndexAndCanBuy.getKey() + 1, false);
            Pair<Integer, Boolean> heldKey = new Pair<>(currIndexAndCanBuy.getKey() + 1, true);

            int purchased = calculateMaxProfit(prices, purchasedKey, stateAndIndexToMaxProfit)
                - prices[currIndexAndCanBuy.getKey()];
            int held = calculateMaxProfit(prices, heldKey, stateAndIndexToMaxProfit);

            stateAndIndexToMaxProfit.put(currIndexAndCanBuy, Math.max(purchased, held));
        }else{ // !canBuy (sell)
            Pair<Integer, Boolean> soldKey = new Pair<>(currIndexAndCanBuy.getKey() + 2, true); // skip one for cooldown
            Pair<Integer, Boolean> heldKey = new Pair<>(currIndexAndCanBuy.getKey() + 1, false);

            int sold = calculateMaxProfit(prices, soldKey, stateAndIndexToMaxProfit)
                + prices[currIndexAndCanBuy.getKey()];
            int held = calculateMaxProfit(prices, heldKey, stateAndIndexToMaxProfit);

            stateAndIndexToMaxProfit.put(currIndexAndCanBuy, Math.max(sold, held));
        }
        
        return stateAndIndexToMaxProfit.get(currIndexAndCanBuy);
    }
}