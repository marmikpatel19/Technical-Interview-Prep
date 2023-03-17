import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Subsets {
    // "all possible" => backtracking

    // time: O(nlog(n)2^n), space: O(n)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        findSubsets(nums, subsets, new ArrayList<>(), 0);

        return subsets;
    }

    private void findSubsets(int[] nums, List<List<Integer>> subsets, List<Integer> currSubset, int currIndex) {
        // this is very important! If a new arraylist is not created, the same one is
        // reused
        subsets.add(new ArrayList<>(currSubset));

        for (int i = currIndex; i < nums.length; i++) {
            currSubset.add(nums[i]);

            // sort to ensure that duplicates can be detected
            Collections.sort(currSubset);

            // only do recursive call if the current element is not a duplicate
            if (!subsets.contains(currSubset)) {
                findSubsets(nums, subsets, currSubset, i + 1);
            }

            // because the array was sorted after insertion, the last element cannot be
            // removed.
            // Instead, the inserted element specifically must be removed.
            currSubset.remove(Integer.valueOf(nums[i]));
        }
    }
}