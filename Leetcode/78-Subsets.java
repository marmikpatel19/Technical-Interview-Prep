class Subsets {
    // "all possible": backtracking
    
    // same element cannot appear multiple times 

    // to understand the algorithm, trace it out for the example [1, 2, 3]

    // Time: O(n*2^n) -- at each number, there are two choices: to include that number in the currSubset or not to inlcude it
    // Space: O(n) -- the recursive call stack goes n deep
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> subsets = new ArrayList<>();

        findSubsets(nums, 0, new ArrayList<>(), subsets);

        return subsets;
    }

    private void findSubsets(int[] nums, int currIndex, List<Integer> currSubset,List<List<Integer>> subsets){
        // add the current subset to subsets
        subsets.add(new ArrayList<>(currSubset));

        // start at currIndex to exhaust all the combinations concerning a particular element and disclude it from
        // future iterative calls, so that it does not appear again (prevent duplication)
        for(int i = currIndex; i < nums.length; i++){
            currSubset.add(nums[i]);

            findSubsets(nums, i + 1, currSubset, subsets);

            currSubset.remove(currSubset.size() - 1);       
        }
    }
}