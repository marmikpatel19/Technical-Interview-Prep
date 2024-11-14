class ShortestPathinBinaryMatrix {
    /**
    Clarifications
        - is it a sqaure right?
        - dumb way to just say that the path is connected, including diagonally
        - n > 1 or empty allowed
    
    approaches
        - DFS  
        O(8^n^2), space: O(8^n^2 + 8^n^2)
        - BFS. w nxn matrix to maintain a visited array. call on every adjacent
        unvisied cell that exists. keep track of the path length as an attribute
        in the queue node obj
        time: , space: O(n^2 + n^2) -- queue and visited array
        - BFS but visited array in place
        time: , space: O(n^2)

    tests
        - regular case
        - no paths
        - two valid paths but shorter one
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        // handle edge cases up front to save time
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1){return -1;}

        int pathLength = 0;
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, 
        {1, 0}, {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};

        Queue<int[]> q = new LinkedList<>();
        int[] root = new int[]{0, 0, 1};
        q.add(root);

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[0] == grid.length - 1 && curr[1] == grid[0].length - 1){
                return curr[2];
            }

            grid[curr[0]][curr[1]] = 1;

            for(int[] direction : directions){
                if(curr[0] + direction[0] >= 0 && curr[0] + direction[0] < grid.length
                && curr[1] + direction[1] >= 0 && curr[1] + direction[1] < grid[0].length
                && grid[curr[0] + direction[0]][curr[1] + direction[1]] == 0){
                    int[] newDirection = new int[]{curr[0] + direction[0], 
                    curr[1] + direction[1], curr[2] + 1};
                    q.add(newDirection);

                    grid[curr[0] + direction[0]][curr[1] + direction[1]] = 1;
                }
            }
        }

        return -1;
    }
}