import java.util.HashMap;

class ContainsDuplicate {
    // time: O(n), space: O(n)
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> freqs = new HashMap<>();

        for (int num : nums) {
            if (!freqs.containsKey(num)) {
                freqs.put(num, 1);
            } else {
                return true;
            }
        }

        return false;
    }
}