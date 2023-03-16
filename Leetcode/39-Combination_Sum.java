import java.util.ArrayList;
import java.util.List;

class CombinationSum {
    /*
     * time: O(nCr) -- calculating every combination
     * space: O(longest_combination * number_of_combinations)
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // // sort to allow traversing in increasing order
        java.util.Arrays.sort(candidates);

        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> currComb = new ArrayList<>();

        findCombinations(candidates, target, combinations, currComb, 0, 0);

        return combinations;
    }

    /*
     * Iterate through the state space tree, which is organized in the following
     * manner: each level represents the number
     * of elements in the current combination and each node in the tree represents a
     * combination. So, lower levels
     * contain more elements; thus, if a combination higher up in the tree exceeds
     * the target, then the algorithm
     * may backtrack as lower levels only consist of more numbers.
     * 
     * currIndex is used to iterate through every array index
     */
    private void findCombinations(int[] candidates, int target, List<List<Integer>> combinations,
            List<Integer> currComb, int currSum, int currIndex) {
        // if the current sum is greater than the target, backtrack because all lower
        // levels would only add more numbers
        if (currSum > target) {
            return;
        }

        // if the current combination matches the target, add the value to comvinations
        // and backtrack as all lower levels
        // would only add more numbers
        else if (currSum == target) {
            combinations.add(new ArrayList<Integer>(currComb));
            return;
        }

        // if the current combination is less than the target, recurse to lower levels:
        // for the current index, interate
        // through all candidates from the current one onwards
        else {
            for (int i = currIndex; i < candidates.length; i++) {
                // update variables used for recursion
                currComb.add(candidates[i]);
                currSum += candidates[i];

                // recursive call down one level
                findCombinations(candidates, target, combinations, currComb, currSum, i);

                // undo changes to variables used in recursion after returning from recursive
                // call
                currComb.remove(currComb.size() - 1);
                currSum -= candidates[i];
            }
        }
    }
}