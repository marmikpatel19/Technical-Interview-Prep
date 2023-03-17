import java.util.HashMap;

class LinkedListCycle {
    // time: O(n), space: O(n)
    public int majorityElement(int[] nums) {
        // keep track of numbers and their frequencies
        HashMap<Integer, Integer> freqs = new HashMap<>();

        // insert numbs and their frequences into the hashmap
        for (int num : nums) {
            if (freqs.containsKey(num)) {
                freqs.put(num, freqs.get(num) + 1);
            } else {
                freqs.put(num, 1);
            }
        }

        int highestFreqNum = 0;
        int highestFreq = 0;

        // find the num with the highest frequency
        for (int num : freqs.keySet()) {
            if (freqs.get(num) > highestFreq) {
                highestFreqNum = num;
                highestFreq = freqs.get(num);
            }
        }

        return highestFreqNum;
    }
}