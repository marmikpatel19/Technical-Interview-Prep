class RottingOranges{
    // time: O(nm), space: O(nm)
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
      int m = grid[0].length;
      int time = 0;
      Queue<int[]> rottenOranges= new LinkedList<>();
      int numFresh = 0;
      int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

      // initialize rotten oranges
      for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
          if(grid[i][j] == 2){
            int[] coor = new int[2];
            coor[0] = i;
            coor[1] = j;
            rottenOranges.add(coor);
          }else if(grid[i][j] == 1){
            numFresh++;
          }
        }
      }

      // go through eahc cycle (minute) of bfs spread
      while(rottenOranges.size() > 0){
        int currSize = rottenOranges.size();
        int originalNumFresh = numFresh;
        for(int i = 0; i < currSize; i++){
          int[] coord = rottenOranges.remove();
          int x = coord[0];
          int y = coord[1];

          for(int[] direction : directions){
            int newX = x + direction[0];
            int newY = y + direction[1];

            if(newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1){
              int[] newCoor = {newX, newY};
              rottenOranges.add(newCoor);
              grid[newX][newY] = 2;
              numFresh--;
            }
          }
        }

        if(originalNumFresh != numFresh){time++;}
      }

      if(numFresh > 0){
        return -1;
      }   

      return time;
    }
}