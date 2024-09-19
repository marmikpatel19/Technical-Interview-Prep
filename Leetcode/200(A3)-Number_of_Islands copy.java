class NumberofIslandsA2 {
    /**
    Iterate through array. for each island encountered, perform
    dfs to find all nodes. when visiting a node, set it to zero.
     */

    // time: O(nm), space: O(1)
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int n = grid.length;
        int m = grid[0].length;

        // traverse the whole graph looking for islands
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                // island found => traverse it and update graph in-place
                if(grid[r][c] == '1'){
                    numIslands++;
                    dfs(grid, r, c, n, m);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][]grid, int r, int c, int n, int m){
        if(grid[r][c] == '0'){
            return;
        }

        // 'visit'
        grid[r][c] = '0';

        // recurse dfs
        if(r + 1 < n){
            dfs(grid, r + 1, c, n, m);
        }
        if(r - 1 >= 0){
            dfs(grid, r - 1, c, n, m);
        }
        if(c + 1 < m){
            dfs(grid, r, c + 1, n, m);
        }
        if(c - 1 >= 0){
            dfs(grid, r, c - 1, n, m);
        }
    }
}