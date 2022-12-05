import java.util.HashMap;

/* Question 1.8: Zero Matrix */

/*
 * Question: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0
 */

/*
 * Examples
 * 1 0 
 * 2 3
 *
 * -> 
 * 0 0
 * 2 0
 */

/*
 * assumptions
 * 
 */

/* Solution */

class Tuple {
    public int x;
    public int y;

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ZeroMatrix {
    // time: O(mn) space: O(mn)
    public static void zeroMatrix(int[][] matrix) {

        // edge cases
        if ((matrix.length == 0 && matrix[0].length == 0) || (matrix.length == 1 && matrix[0].length == 1)) {
            return;
        }

        // store tuples of elements with zero
        HashMap<Integer, Tuple> zeros = new HashMap<>();

        // find all the zero's
        int key = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeros.put(key, new Tuple(i, j));
                }
            }
            key++;
        }

        // replace rows and columns with zeros
        replaceWithZeros(zeros, matrix);
    }

    public static void replaceWithZeros(HashMap<Integer, Tuple> zeros, int[][] matrix) {
        // replace row and column with zeros
        for (Tuple zero : zeros.values()) {
            // replace row with 0s
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[zero.x][i] = 0;
            }

            // replace column with 0s
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][zero.y] = 0;
            }
        }
    }

    public static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[][] m1 = { { 1, 0 }, { 2, 3 } };
        zeroMatrix(m1);
        printMatrix(m1);
        /*
         * 0 0
         * 2 0
         */

        int[][] m2 = { { 1, 2 }, { 2, 3 } };
        zeroMatrix(m2);
        printMatrix(m2);
        /*
         * 1 2
         * 2 3
         */

        int[][] m3 = { { 1, 2 }, { 2, 3 }, { 3, 0 } };
        zeroMatrix(m3);
        printMatrix(m3);
        /*
         * 1 0
         * 2 0
         * 0 0
         */

        int[][] m4 = { { 1, 2, 4, 10 }, { 2, 0, 4, 9 } };
        zeroMatrix(m4);
        printMatrix(m4);
        /*
         * 1 0 4 10
         * 0 0 0 0
         */

        int[][] m5 = { { 0, 2, 4, 10 }, { 2, 0, 4, 9 } };
        zeroMatrix(m5);
        printMatrix(m5);
        /*
         * 0 0 0 0
         * 0 0 0 0
         */

    }
}