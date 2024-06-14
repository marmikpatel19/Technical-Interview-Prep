class WordSearchA2 {
    /**Backtracking

    iterate theough every char

    for a char that matches, recursively check each char
    around it, using an arraylist to keep track of 
    visited indices
     */

    // time: O(m*n*4^L), space: O(L), where L is word.length()
    public boolean exist(char[][] board, String word) {
        //edge case
        if(board.length == 1 && board[0].length == 1 
        && word.length() == 1){return board[0][0] == word.charAt(0);}

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    Pair<Integer, Integer> currentCoords = 
                    new Pair<>(i, j);
                    ArrayList<Pair<Integer, Integer>> 
                    currentSolution = new ArrayList<>();

                    if(checkWord(board, word, 0, currentCoords,
                    currentSolution)){return true;}
                }
            }
        }

        return false;
    }

    private boolean checkWord(char[][] board, String word, int i, 
    Pair<Integer, Integer> currentCoords, 
    ArrayList<Pair<Integer, Integer>> currentSolution){
        // base cases
        if(i >= word.length()){return true;}
        if(board[currentCoords.getKey()][currentCoords.getValue()] 
        != word.charAt(i) || currentSolution.contains(currentCoords))
        {return false;}

        currentSolution.add(currentCoords);
        
        // recursive checks in each direction
        if(currentCoords.getKey() + 1 < board.length){
            if(checkWord(board, word, i + 1, 
            new Pair<Integer, Integer>(currentCoords.getKey() + 1,
            currentCoords.getValue()), currentSolution)){return true;}
        }
        if(currentCoords.getKey() - 1 >= 0){
            if(checkWord(board, word, i + 1, 
            new Pair<Integer, Integer>(currentCoords.getKey() - 1,
            currentCoords.getValue()), currentSolution)){return true;}
        }
        if(currentCoords.getValue() + 1 < board[0].length){
            if(checkWord(board, word, i + 1, 
            new Pair<Integer, Integer>(currentCoords.getKey(),
            currentCoords.getValue() + 1), currentSolution)){return true;}
        }
        if(currentCoords.getValue() - 1 >= 0){
            if(checkWord(board, word, i + 1, 
            new Pair<Integer, Integer>(currentCoords.getKey(),
            currentCoords.getValue() - 1), currentSolution)){return true;}
        }
        
        currentSolution.remove(currentCoords);

        return false;
    }
}