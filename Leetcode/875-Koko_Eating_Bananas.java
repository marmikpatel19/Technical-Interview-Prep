class KokoEatingBananas {
    /**
    The eating speed (k) must be > 0 and <= max(piles), since using
    the max size will gaurantee that all the piles can be eaten
    in one hour each.

    Given these bounds, we can make a rannge of 1 <= k <= max(piles) 
    and do a binary search to find the smallest k.

    At each check, if h is exceed, go right; if h is met, go left. 
     */

    // time: O(nlog(max(piles))), space: O(1)
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = piles[0];
        // initialize r to max
        for(int i = 0; i < piles.length; i++){
            r = Math.max(r, piles[i]);
        }
        int minSpeed = r; // initialize minSpeed to max

        // binary search until min eating speed is found
        while(l <= r){
            int mid = (l + r) / 2;
            int currentHours = 0;

            // count number of hours to eat current pile
            for(int i = 0; i < piles.length; i++){
                currentHours += (piles[i] + mid - 1) / mid; // ceiling division
            }

            if(currentHours > h){
                l = mid + 1;
            }
            else{
                r = mid - 1;
                if(currentHours > 0){minSpeed = Math.min(minSpeed, mid);}
            }
        }

        return minSpeed;
    }
}