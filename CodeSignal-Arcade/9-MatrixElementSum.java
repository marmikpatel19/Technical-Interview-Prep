class MatrixElementSum {
    /**
    Maintain a list columns to visit. when a 0 is encoutered, remove 
    that column from the list (skip it in future iterations).
    */

    // time: O(nm), space: O(nm)
    int solution(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int sum = 0;
        
        ArrayList<Integer> columns = new ArrayList<>();
        for(int i = 0; i < m; i++){
            columns.add(i);
        }
        
        for(int r = 0; r < n; r++){
            Iterator<Integer> iter = columns.iterator();
            while(iter.hasNext()){
                int c = iter.next();
                sum += matrix[r][c];
                if(matrix[r][c] == 0){
                    iter.remove();
                }
            }
        }
        
        return sum;
    }
}