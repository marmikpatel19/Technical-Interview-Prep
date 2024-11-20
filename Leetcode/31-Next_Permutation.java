class  NextPermutation{
    /**
    clarifications
        - empty array, do nothing right? 
        - duplicate numbers? --> yes
        - already sorted in decreasing? go to nondecreasing
        - understnading the question 
            we can to find the next largest number that comes
            after the current one. not just any larger number,
            but the next largest one.
            e.g.,:
                123 -> 132
                14587 -> 14758
            
            because it's the next largest one (smallest increase),
            we want to traverse from the right and find the first
            number that is not increasing (e.g., 5 in 14587).

            then, we want to swap the smallest number found on the 
            right side w it (14587 -> 14785)

            Then, we want to sort all the right numbers in increasing
            order (147|85 -> 147|58)

    approaches
        - brute force: generate every permutation in order. find the current one
            and then return the next one
            T: (n!), S: O(N)

        - see above
            T: O(N), S: O(1)

    tests
        - regular
        - single element
        - multiple swaps/sorting
        - sorted case
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1){return;}

        // find pivot (first number from the right that's not increasing)
        int pivotIndex = -1;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                pivotIndex = i;
                break;
            }
        }

        // edge case where the array's at the final permutation
        if(pivotIndex == -1){
            // reverse array
            int l = 0;
            int r = n - 1;

            while(l < r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }

            return;
        }

        // swap pivot with first number from the right
        // that's greater than pivot
        for(int i = n - 1; i > pivotIndex; i--){
            if(nums[i] > nums[pivotIndex]){
                int temp = nums[pivotIndex];
                nums[pivotIndex] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        // sort all numbers on the right of the pivot
        // in increasing order. these are all in
        // decreasing order rn
        int l = pivotIndex + 1; 
        int r = n - 1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}

