package Leetcode;

class TwoSum {
    // time: O(n^2)
    public int[] twoSum(int[] nums, int target) {
        int[] indicies = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    indicies[0] = i;
                    indicies[1] = j;
                    return indicies;
                }
            }
        }
        return indicies;
    }

    // Attempt two after solution. Time: O(n), space O(n)
    // class TwoSum {
    // // time: O(n), space O(n)
    // public int[] twoSum(int[] nums, int target) {
    // HashMap<Integer, Integer> complements = new HashMap<>();

    // for (int i = 0; i < nums.length; i++) {
    // complements.put(target - nums[i], i);
    // }

    // for (int i = 0; i < nums.length; i++) {
    // if (complements.containsKey(nums[i]) && i != complements.get(nums[i])) {
    // return new int[] { complements.get(nums[i]), i };
    // }
    // }

    // return null;
    // }
    // }

}