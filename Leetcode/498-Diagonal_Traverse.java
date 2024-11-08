class DiagonalTraverse {
    /*
    when going topright we move right and up; when going bottom left
    we move down and left. 

    This results in one of three cases:
        1) there's a valid element there
            great, add it in
        2) out of index but by one (e.g., case w 1 and 4 in ex)
            if topright, r--. if bottomleft, c++.
        3) out of index by 3 (e.g., case w 3 and 8 in ex)
            if topright, r+=2, c--. if bottomleft, c-=2, r--;

    We want to run the while loop as per the res array and not the actual 
    matrix because r and c will be changing constantly. 
    */
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] res = new int[n * m];
        int i = 0;

        boolean goTopRight = true;
        int r = 0;
        int c = 0;
        res[i] = mat[r][c];
        i++;

        while(i < n*m){
            if(goTopRight){
                c++;
                r--;

                if(c >= m || r < 0){ 
                    goTopRight = !goTopRight;
                    r++;

                    if(c >= m || r < 0){ 
                        r++;
                        c--;
                    }
                }
            }else{
                r++;
                c--;

                if(c < 0 || r >= n){ 
                    goTopRight = !goTopRight;
                    c++;

                    if(c < 0 || r >= n){ 
                        r--;
                        c++;
                    }
                }
            }  

            res[i] = mat[r][c];
            i++; 
        }

        return res;
    }
}