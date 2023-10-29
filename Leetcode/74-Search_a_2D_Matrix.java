class Searcha2DMatrix {
    /**
    Double binary search. The first one determines the row; the second determins the value. 
     */
 
    // time: O(log(m) + log(n)), space: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int min = 0;
        int max = n - 1;

        // find current row
        while(min <= max){
            System.out.println(min + ", " + max); 
            int middle = (min + max) / 2;

            if(target > matrix[middle][m - 1]){
                min = middle + 1;
            }
            else if(target < matrix[middle][0]){
                max = middle - 1;
            }
            // this else is hit if because target is not less than smallest in row
            // and is not larger than largest in row---i.e., target is in the (middle) row
            else{ 
                break;
            }
        }
        if(min > max){return false;}
        
        int row = (min + max) / 2;
        min = 0;
        max = m - 1;

        // find value in the correct row that we now have 
        while(min <= max){
            int middle = (min + max) / 2;

            if(matrix[row][middle] == target){return true;}
            else if(target > matrix[row][middle]){
                min = middle + 1;
            }
            else{
                max = middle - 1;
            }
        }

        return false;
    }
}