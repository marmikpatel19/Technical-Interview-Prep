/* Question 1.7: Rotate Matrix */

/*
 * Question: Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */

/*
 * Assumptions
 * 90 degrees clockwise
 */

/* Solution */

class RotateMatrix {

    // time (n^2), space: O(1)
    public static void rotateMatrix(int[][] image) {
        if (image.length <= 1) {
            return;
        }

        // determine if num rows is odd/even
        int halfway;
        if (image.length % 2 == 0) {
            halfway = image.length / 2;
        } else {
            halfway = image.length / 2 + 1;
        }

        int n = image.length;

        // Iterate through top N/2 by N/2 pixels
        // i = x, j = y
        for (int i = 0; i < halfway; i++) {
            for (int j = 0; j < halfway; j++) {

                /* do four rotations */

                int temp = image[i][j];

                // the middle row in odd-leveled matrices is repeated; we prevent this
                // repeated transformation
                if (!(image.length % 2 != 0 && i == image.length / 2)) {
                    // left -> top
                    image[i][j] = image[n - 1 - j][i];

                    // bottom -> left
                    image[n - 1 - j][i] = image[n - 1 - i][n - 1 - j];

                    // right -> bottom
                    image[n - 1 - i][n - 1 - j] = image[j][n - 1 - i];

                    // top -> right
                    image[j][n - 1 - i] = temp;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        StringBuilder m = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                m.append(matrix[i][j] + " ");
            }
            m.append("\n");
        }

        System.out.println(m);
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 2 }, { 3, 4 } };
        rotateMatrix(m);
        printMatrix(m);
        /*
         * 1 2
         * 3 4
         * 
         * ->
         * 
         * 3 1
         * 4 2
         */

        int[][] m2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // printMatrix(m2);
        rotateMatrix(m2);
        printMatrix(m2);
        /*
         * 1 2 3
         * 4 5 6
         * 7 8 9
         * 
         * ->
         * 
         * 7 4 1
         * 8 5 2
         * 9 6 3
         */

        int[][] m3 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
        rotateMatrix(m3);
        printMatrix(m3);
        /*
         * 1 2 3 4 5
         * 6 7 8 9 10
         * 11 12 13 14 15
         * 16 17 18 19 20
         * 21 22 23 24 25
         * 
         * ->
         * 
         * 21 16 11 6 1
         * 22 17 12 7 2
         * 23 18 13 8 3
         * 24 19 14 9 4
         * 25 20 15 10 5
         */
    }
}