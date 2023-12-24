class LongestConsecutiveSequence {
    /**
    Find all the sequences. If we have all the sequences, then we can easily determine which 
    is the longest. We can determine if a set of numbers is a sequence by identifying its
    first number--it should not have a predecessor. 

    We can query each number in the array to see if it's the start of a sequence by using a
    hashmap for O(1) lookup
     */

    // time: O(n), space: O(n)
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numsLookup = new HashSet<>();
        int longest = 0;

        for(int num : nums){
            numsLookup.add(num);
        }

        for(int num : nums){
            if(!numsLookup.contains(num - 1)){
                int tempLongest = 1;
                int iter = 1;

                while(numsLookup.contains(num + iter)){
                    tempLongest++;
                    iter++;
                }

                longest = Math.max(longest, tempLongest);
            }
        }

        return longest;
    }
}