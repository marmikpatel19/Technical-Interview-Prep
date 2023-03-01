import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ThreeSum {
    // time: O(n^2), space: O(n)
    public List<List<Integer>> threeSum(int[] nums) {

        // A HashSet is used because, by definition, it prevents duplicates
        Set<List<Integer>> triplets = new HashSet<>();

        // sort nums to allow for start and end iterators
        java.util.Arrays.sort(nums);

        // iterate through every num
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            // iterate through every two-number combination
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                // sum == 0, add it into array
                if (sum == 0) {
                    triplets.add(java.util.Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }
                // sum is negative, so move right
                else if (sum < 0) {
                    l++;
                }
                // sum is positive, so move left
                else if (sum > 0) {
                    r--;
                }
            }
        }

        return new ArrayList<>(triplets);
    }
}