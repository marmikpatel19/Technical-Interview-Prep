import java.util.ArrayList;
import java.util.List;

class PermutationsonSum {
    // "all possible" => backtracking

    // time: O(nCr), space: O(n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();

        findPerms(nums, perms, new ArrayList<>());

        return perms;
    }

    private void findPerms(int[] nums, List<List<Integer>> perms, List<Integer> currPerm) {
        if (currPerm.size() == nums.length) {
            perms.add(new ArrayList<>(currPerm));
        } else {
            System.out.println(currPerm);

            for (int i = 0; i < nums.length; i++) {
                if (!currPerm.contains(nums[i])) {
                    currPerm.add(nums[i]);

                    findPerms(nums, perms, currPerm);

                    currPerm.remove(Integer.valueOf(nums[i]));
                }
            }
        }
    }
}