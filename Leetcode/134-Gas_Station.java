class GasStation {
    /*
     * Important ideas:
     * - if the total gas > total cost, then there is a route possible; thus, this
     * is all we need to calculate in the questions. This also allows for O(n)
     * because we only need to iterate through the array(s) once.
     * - the starting index can be found to be the index after one where the gas
     * runs out; this is because if there is not route between some station A and B,
     * then there cannot be a route from any station after A to B. Thus, we must use
     * a station before A; for convience, why not simply use the one successding a
     * station that leads to gas running out
     */

    // time: O(n), space: O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int curGas = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            // update total gas and cost
            totalGas += gas[i];
            totalCost += cost[i];
            curGas += gas[i];
            curGas -= cost[i];

            // if we've ran out of gas, restart curGas
            if (curGas < 0) {
                curGas = 0;

                if (i + 1 == gas.length) {
                    startStation = 0;
                } else {
                    startStation = i + 1;
                }
            }
        }

        if (totalGas >= totalCost) {
            return startStation;
        } else {
            return -1;
        }
    }
}