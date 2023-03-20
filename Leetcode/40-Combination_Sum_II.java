import java.util.ArrayList;
import java.util.List;

class CombinationSumII {
    // "find all", "candidates" => backtracking

    // time: O(2^N), space: O(n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        java.util.Arrays.sort(candidates);
        List<List<Integer>> combs = new ArrayList<>();

        findCombs(candidates, combs, target, new ArrayList<>(), 0, 0);

        return combs;
    }

    private void findCombs(int[] candidates, List<List<Integer>> combs, int target, List<Integer> currComb, int currSum,
            int currIndex) {
        // if target it met, add it to combs and backtrack
        if (currSum == target) {
            combs.add(new ArrayList<>(currComb));
        }

        // if the target is exceeded, backtrack
        else if (currSum > target) {
            return;
        }

        // the currSum is less than target so continue recursing
        else {
            for (int i = currIndex; i < candidates.length; i++) {
                /*
                 * Skip duplicates
                 * 
                 * "i > currIndex" is used to check that the algorithm is not on a new element
                 * (if this is the case, then
                 * there cannot be a duplicate)
                 * 
                 * "candidates[i] == candidates[i-1]" is used the check that the same number is
                 * not used more than one in the
                 * same combination, which would case duplication. The current element is
                 * compared with the previous one
                 * because Candidates is sorted at the beginning, so all duplicate numbers are
                 * beside each other.
                 * 
                 */
                if (i > currIndex && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                currComb.add(candidates[i]);
                currSum += candidates[i];

                findCombs(candidates, combs, target, currComb, currSum, i + 1);

                currSum -= candidates[i];
                currComb.remove(Integer.valueOf(candidates[i]));
            }
        }
    }
}