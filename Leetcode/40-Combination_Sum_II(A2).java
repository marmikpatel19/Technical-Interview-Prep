import java.util.ArrayList;
import java.util.List;

class CombinationSumII(A2) {
    /** typical backtracking. but "trick" with duplication avoidance (see below)
     */

    // time: O(2^n), space: O(n) 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // to enable us to do the trick below for checking for duplicate combinations
        List<List<Integer>> solutions = new ArrayList<>();

        backtrack(candidates, target, solutions, new ArrayList<Integer>(), 0, 0);

        return solutions;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> solutions, List<Integer> currSolution, int currIndex, int currSum){        
        // base cases
        if(currSum > target){return;}
        if(currSum == target){        
            solutions.add(new ArrayList<>(currSolution));
            return;
        }
        
        for(int i = currIndex; i < candidates.length; i++){
            /**
            We need to prevent duplicate combinations. We cannot just do !solutions.contains(currSolution) 
            above b/c that adds too much complexity.

            So, we use a trick during the initial iteration:

            e.g., [1, 1, 2, 5, 6, 7, 10]

            When do duplicate combinatins arise? say, [1, 7] and [1, 7].
            
            Well, it's when we use the first 1 at index 0 with 7 AS WELL AS the second one with index
            1. Recursing through all the solutions starting with index 0 and 1 produce the same 
            solution!! except the case where we need to using both one's. 

            So, let's implement logic to skip over duplications of a given number. e.g., skipping
            the second 1 at index 1 and moving directly to 2 at index 2. 

            To skip the number (inside the if check), we can use continue; (skips the current
            iteration).

            We can check if the number is duplicate by comapring it with the previous one:
            candidates[i] == candidates[i - 1];

            But we have one edge case to handle, as shown by this ongoing example. We do not 
            want to skip the instance where multiple instances of the number are used in the
            SAME solution (e.g., [1, 1, 6]). In this scenario, when the second one's 
            recursive call is called, the currIndex is 1. But the new for loop begins at 1. 
            In otherwords, currIndex == i. This is what we DO NOT want to skip. So,
            the if statement would include currIndex != i. 

            To validate this, take the scenario that we want to skip: we are starting a new
            solution at index 1. Well, i = 1 (parent for loop). currIndex = 0 (from
            the first/initial loop passed in). 
             */
            if(i - 1 > -1 && currIndex != i && candidates[i] == candidates[i - 1]){
                continue;
            }

            // add curr num
            currSolution.add(candidates[i]);
            currSum += candidates[i];

            // recursive call
            backtrack(candidates, target, solutions, currSolution, i + 1, currSum);

            // remove curr num
            currSum -= candidates[i];
            currSolution.remove(Integer.valueOf(candidates[i]));
        }
    }
}