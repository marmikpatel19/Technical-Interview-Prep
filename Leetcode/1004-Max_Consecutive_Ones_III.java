class MaxConsecutiveOnesIII {
    /**
    clarifications
        - not forced to flip k right
        - empty array? --> at least size 1
        - only 1s and 0s
        - k is valid 
    approaches
        - brute force
            going throuhg every combination of placing
            the ones: T: O9(n^k)
        - sliding window
            keep track of numzeros. the size of the 
            window the number of ones. if numzeros 
            exceeds k, keep iterating l until
            it doesn't. 

            T: O(N), S: O(1)
    
    tests
        - longest is on left and right
        - longest is connecting
        - single value array
        - zero flips 
        - k = 0
     */
    public int longestOnes(int[] nums, int k) {
        int maxOnes = 0;
        int numCurrFlipped = 0;
        int l = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                numCurrFlipped++;
                
                while(numCurrFlipped > k){
                    if(nums[l] == 0){
                        numCurrFlipped--;
                    }
                    l++;
                }
                
            }
            maxOnes = Math.max(maxOnes, i - l + 1);
        }

        return maxOnes;
    }
}