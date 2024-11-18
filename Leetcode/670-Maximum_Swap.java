class MaximumSwap {
    // 98218

    /**
    clarificatiosn
        - just zero -> no swaps

    approach
        essentially, for each digit, we need to find the largest
        number to the right of it. e.g., for 2736, at 2 is 7, and 
        7 is nothing, at 3 is 6, and at 6 is nothing. So, we iterate
        through the array from the right and at each index store
        the largest number (index of it) to the right of it 
        (if it exists)

        then, we want to swap the leftmost digit that has a number
        that is larger than it on the right. so, we iterate
        from the left this time and swap the first digit we find
        with this case. 

        1) create char array representing the digis of the string
            to do this we can just conver the number to a string and
            then the string to a char array

        2) create a seperate maxSoFar array that represents the index 
            of the max number come across so far from the right side. 
            if the current number is the max, store its index.
            iterate backwards through the char digit array and update
            the maxSoFar array.
    
        3) iterate through the char digit array from the front (start 
            of the number). swap the first digit we come across that
            has a number on the righer side of the arrsay that is larger
            (i.e., curr num != max stored in maxSoFar array). when you 
            swap, break.
        
        make the array back into a string and return. 

        T: O(n), space: O(n)
     */
    public int maximumSwap(int num) {
        // create char array representation of num
        char[] digits = String.valueOf(num).toCharArray();

        // create array of indicies representing the max
        // num come across so far from the right
        int[] maxSoFarIndices = new int[digits.length];
        int maxIndex = digits.length - 1;
        for(int i = digits.length - 1; i >= 0; i--){
            if(Integer.valueOf(Character.toString(digits[i])) > 
            Integer.valueOf(Character.toString(digits[maxIndex]))){
                maxSoFarIndices[i] = i;
                maxIndex = i;
            }else{
                maxSoFarIndices[i] = maxIndex;
            }
        }

        // iterate from the left and swap the first num
        // that has a max later than it
        for(int i = 0; i < digits.length; i++){
            if(Integer.valueOf(Character.toString(digits[i])) < 
            Integer.valueOf(Character.toString(digits[maxSoFarIndices[i]]))){
                char temp = digits[i];
                digits[i] = digits[maxSoFarIndices[i]];
                digits[maxSoFarIndices[i]] = temp;
                break;
            }
        }

        return Integer.valueOf(new String(digits));
    }
}