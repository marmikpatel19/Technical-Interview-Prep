class SetMatrixZeroes {
    /**
    Iterate through the matrix; for each 0 found, add the row and column to a seperate row and 
    column sets.

    Iterate through both sets, replacing corresponding rows/columns with 0s
    */

    // time: O(mn), space: O(m + n)
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                if(matrix[r][c] == 0){
                    rows.add(r);
                    cols.add(c);
                }
            }
        }

        for(Integer r : rows){
            for(int c = 0; c < matrix[0].length; c++){
                matrix[r][c] = 0;
            }
        }
        for(Integer c : cols){
            for(int r = 0; r < matrix.length; r++){
                matrix[r][c] = 0;
            }
        }

        return;
    }
}