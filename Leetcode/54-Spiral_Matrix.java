import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    // time: O(m x n), space: O(m x n)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> traversal = new ArrayList<>();

        int row = 0;
        int col = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        traversal.add(matrix[row][col]);
        matrix[row][col] = -101;

        for (int i = 0; i < m * n; i++) {
            boolean movementDone = false;

            // movement with order right, bottom, left, top
            if (col + 1 <= n - 1 && matrix[row][col + 1] != -101 && !movementDone) {
                col++;
                traversal.add(matrix[row][col]);
                matrix[row][col] = -101;

                while (col + 1 <= n - 1 && matrix[row][col + 1] != -101) {
                    col++;
                    traversal.add(matrix[row][col]);
                    matrix[row][col] = -101;
                    i++;
                }

                movementDone = true;
            } else if (row + 1 <= m - 1 && matrix[row + 1][col] != -101 && !movementDone) {
                row++;
                traversal.add(matrix[row][col]);
                matrix[row][col] = -101;

                while (row + 1 <= m - 1 && matrix[row + 1][col] != -101) {
                    row++;
                    traversal.add(matrix[row][col]);
                    matrix[row][col] = -101;
                    i++;
                }
                movementDone = true;
            } else if (col - 1 >= 0 && matrix[row][col - 1] != -101 && !movementDone) {
                col--;
                traversal.add(matrix[row][col]);
                matrix[row][col] = -101;

                while (col - 1 >= 0 && matrix[row][col - 1] != -101) {
                    col--;
                    traversal.add(matrix[row][col]);
                    matrix[row][col] = -101;
                    i++;
                }

                movementDone = true;
            } else if (row - 1 >= 0 && matrix[row - 1][col] != -101 && !movementDone) {
                row--;
                traversal.add(matrix[row][col]);
                matrix[row][col] = -101;

                while (row - 1 >= 0 && matrix[row - 1][col] != -101) {
                    row--;
                    traversal.add(matrix[row][col]);
                    matrix[row][col] = -101;
                }
            }
        }

        return traversal;
    }
}