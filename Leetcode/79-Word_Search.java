class WordSearch {
    // backtracking where every character is a starting points and the algorithm
    // recurses based
    // on the letters surrounding it. Backtrack when a current path does not fit the
    // word.

    boolean[][] visited;

    // time: O(4^L * n * m), space: O(n * m), where L word.length()
    // 4^L because the algorithm recurses in four directions. in the worst-case
    // where each letter
    // on the board is the starting letter of word, this causes exploration of n * m
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        // search for word only from the elements that start with the starting character
        for (int c = 0; c < board[0].length; c++) {
            for (int r = 0; r < board.length; r++) {
                if (board[r][c] == word.charAt(0) && findWord(board, word, 0, r, c)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean findWord(char[][] board, String word, int currLength, int curRow, int curCol) {
        // found
        if (currLength == word.length()) {
            return true;
        }

        // out of bounds; backtrack
        if (curRow >= board.length || curRow < 0 || curCol >= board[0].length || curCol < 0) {
            return false;
        }

        // current word no longer matches word; backtrack
        if (board[curRow][curCol] != word.charAt(currLength)) {
            return false;
        }

        // currently on an already visited element; backtrack
        if (visited[curRow][curCol]) {
            return false;
        }

        // current word matches; recurse
        else {
            visited[curRow][curCol] = true;

            if (findWord(board, word, currLength + 1, curRow, curCol + 1)
                    || findWord(board, word, currLength + 1, curRow + 1, curCol)
                    || findWord(board, word, currLength + 1, curRow, curCol - 1)
                    || findWord(board, word, currLength + 1, curRow - 1, curCol)) {
                return true;
            }

            visited[curRow][curCol] = false;

            return false;
        }
    }
}