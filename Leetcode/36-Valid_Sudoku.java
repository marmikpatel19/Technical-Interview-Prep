class ValidSudoku {
    // time: O(n^2), space: O(n^2)
    public boolean isValidSudoku(char[][] board) {
        // rows
        for(int r = 0; r < board.length; r++){
           HashMap<Character, Integer> numFreq = new HashMap<>(); 
           
           for(int c = 0; c < board.length; c++){
               if(board[r][c] != '.'){
                   numFreq.put(board[r][c], numFreq.getOrDefault(board[r][c], 0) + 1);
                                   if(numFreq.get(board[r][c]) > 1){return false;}
               }
           }
        }

        // columns
        for(int c = 0; c < board.length; c++){
           HashMap<Character, Integer> numFreq = new HashMap<>(); 
           
           for(int r = 0; r < board.length; r++){
               if(board[r][c] != '.'){
                   numFreq.put(board[r][c], numFreq.getOrDefault(board[r][c], 0) + 1);
                   if(numFreq.get(board[r][c]) > 1){return false;}
               }
           }
        }

        // boxes
       for(int startR = 0; startR < 9; startR+=3){
           for(int startC = 0; startC < 9; startC+=3){
               HashMap<Character, Integer> numFreq = new HashMap<>(); 
               for(int r = startR; r < startR + 3; r++){
                   for(int c = startC; c < startC + 3; c++){
                       if(board[r][c] != '.'){
                           numFreq.put(board[r][c], numFreq.getOrDefault(board[r][c], 0) + 1);
                           if(numFreq.get(board[r][c]) > 1){return false;}
                       }
                   }
               }
           }
       }


        return true;
   }
}