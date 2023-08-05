class NumberofIslands {
    /*
     * number of islands == number of unconnected graphs
     * 
     * Traverse the grid entrirely. Whenever a 1 is encountered, traverse that
     * connected graph
     * using DFS, marking each visited node as 0. Update numIslands += 1.
     */

    char[][] graph;

    // time: O(m x n), space: O(m x n)
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        graph = grid;

        // traverse the whole graph
        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[0].length; col++) {
                // if land is found, traverse the entire island, marking visited land as 0
                if (graph[row][col] == '1') {
                    dfs(row, col);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    private void dfs(int row, int col) {
        graph[row][col] = '0';
        int n = graph.length;
        int m = graph[0].length;

        // DFS recursive calls
        if (row + 1 < n && graph[row + 1][col] == '1') {
            dfs(row + 1, col);
        }
        if (row - 1 >= 0 && graph[row - 1][col] == '1') {
            dfs(row - 1, col);
        }
        if (col + 1 < m && graph[row][col + 1] == '1') {
            dfs(row, col + 1);
        }
        if (col - 1 >= 0 && graph[row][col - 1] == '1') {
            dfs(row, col - 1);
        }
    }
}