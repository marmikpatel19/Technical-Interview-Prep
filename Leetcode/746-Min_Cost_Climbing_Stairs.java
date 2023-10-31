class MinCostClimbingStairs {
    /**
    The cost to reach step n is the Math.min(cost(n - 1), cost(n - 1))

    We can use a bottom-up tabulation approach where we use two variables to store the 
    past two min costs.
     */

     // time: O(n), space: O(1)
     public int minCostClimbingStairs(int[] cost) {
        if(cost.length ==  2){return Math.min(cost[0], cost[1]);}

        int first_min = cost[0];
        int second_min = cost[1];

        for(int i = 2; i < cost.length; i++){
            int temp = second_min;
            second_min = Math.min(first_min + cost[i], second_min + cost[i]);
            first_min = temp;
        }

        return Math.min(first_min, second_min);
    }
}