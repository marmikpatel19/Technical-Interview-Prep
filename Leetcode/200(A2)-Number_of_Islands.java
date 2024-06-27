class NumberofIslandsA2 {
    /**
    Traverse the grid. when land is encountered, dfs to all the connected land,
    updating the peices with 0. And, increment the num of islands
     */

    // time: O(mn), space: O(mn) (call stack; worst-case--all grid is islands)
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int x, int y){
        if(grid[x][y] == '1'){
            grid[x][y] = '0';
            if(x + 1 < grid.length){dfs(grid, x + 1, y);}
            if(x - 1 >= 0){dfs(grid, x - 1, y);}
            if(y + 1 < grid[0].length){dfs(grid, x, y + 1);}
            if(y - 1 >= 0){dfs(grid, x, y - 1);}
        }
    }
}