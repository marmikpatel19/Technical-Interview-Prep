class RotateImage {
    /*
     * Rotate the top left quarter sub matrix four times: iterate through the top
     * left sub
     * matrix and for each element, rotate it four times. For odd-numbered matrices,
     * do not
     * rotate the middle row to prevent duplication.
     */

    // time: O(n), space: O(1)
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int oddCompensatedN = n;
        if (n % 2 != 0) {
            oddCompensatedN++;
        }

        // iterate through top left sub matrix
        for (int col = 0; col < oddCompensatedN / 2; col++) {
            for (int row = 0; row < oddCompensatedN / 2; row++) {
                // don't rotate the middle row for odd matrices
                if (!(n % 2 != 0 && row == n / 2)) {
                    // copy changes for one *counter-clockwise* rotation
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[(n - 1) - col][row];
                    matrix[(n - 1) - col][row] = matrix[(n - 1) - row][(n - 1) - col];
                    matrix[(n - 1) - row][(n - 1) - col] = matrix[col][(n - 1) - row];
                    matrix[col][(n - 1) - row] = temp;
                }
            }
        }
    }
}