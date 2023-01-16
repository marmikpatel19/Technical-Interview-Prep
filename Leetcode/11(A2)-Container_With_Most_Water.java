class ContainerWithMostWater {
    // time: O(n), space: O(1)
    public int maxArea(int[] height) {
        int curWaterAmount = 0;

        /*
         * Greedy algorithm because two properties are met:
         * 1) Greedy Choice Property
         * The maximum water of the whole container (global optimum) can be reached
         * using the maximum waters of subproblems (local optimum)
         * 
         * 2) Optimal substructure
         * The problem can be broken down into subproblems. Namely, we can start by
         * considering the whole container (line 0 to n - 1)). Then, shrink the
         * container from both sides (the subproblems) st we increment the pointer at
         * the lower of the two heights. A variable can be used to keep track of the
         * current largest and used for comparision
         */

        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            curWaterAmount = Math.max(curWaterAmount, (r - l) * Math.min(height[l], height[r]));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return curWaterAmount;
    }
}