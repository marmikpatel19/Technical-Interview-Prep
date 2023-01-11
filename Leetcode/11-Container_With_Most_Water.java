// Correct solution but space complexity too high (rejected by leetcode)

class ContainerWithMostWater {
    // entry (i, j) represents the amount of water contained between indicies i and
    // j
    int[][] waterAmounts;

    // time: O(n^2), space: O(n^2)
    public int maxArea(int[] height) {
        int n = height.length;
        waterAmounts = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                waterAmounts[i][j] = -1;
            }
        }

        return maxArea(height, 0, n);
    }

    private int maxArea(int[] height, int start, int end) {
        // base case
        if (end - start == 1) {
            int waterAmount = java.lang.Math.min(height[start], height[end]);

            waterAmounts[start][end] = waterAmount;
            return waterAmount;
        }

        // from 0 to n; from 0 to n - 1; from 1 to n
        int valueOne, valueTwo, valueThree;
        valueOne = valueTwo = valueThree = 0;

        // intialize values
        if (waterAmounts[start][end] == -1) {
            int width = end - start;
            valueOne = java.lang.Math.min(width * height[start], width * height[end]);
            waterAmounts[start][end] = valueOne;
        } else {
            valueOne = waterAmounts[start][end];
        }
        if (waterAmounts[start][end - 1] == -1) {
            valueTwo = maxArea(height, start, end - 1);
            waterAmounts[start][end - 1] = valueTwo;
        } else {
            valueTwo = waterAmounts[start][end - 1];
        }
        if (waterAmounts[start + 1][end] == -1) {
            valueThree = maxArea(height, start + 1, end);
            waterAmounts[start + 1][end] = valueThree;
        } else {
            valueThree = waterAmounts[start + 1][end];
        }

        // obtain max amount
        int waterAmount = java.lang.Math.max(valueOne, valueTwo);
        waterAmount = java.lang.Math.max(waterAmount, valueThree);

        waterAmounts[start][end] = waterAmount;
        return waterAmount;
    }
}