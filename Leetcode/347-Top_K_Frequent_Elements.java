import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TopKFrequentElements {
    /*
     * bucket sort is used, where each 'bucket' is a list in an array.
     * The indices of the array corresponds to the frequence
     */

    // time: O(nlog(n)), space: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        // Array of lists, where each list is a bucket for all the values with the
        // frequency corresponding
        // to that index
        List<Integer>[] buckets = new List[nums.length + 1]; // +1 for the case where every number is the same
        // key is int in nums, value is frequency
        HashMap<Integer, Integer> freqs = new HashMap<>();

        // traverse nums and add freqs
        for (int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        // insert values into buckets
        for (int key : freqs.keySet()) {
            int freq = freqs.get(key);

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // obtain the k most frequent elements
        int[] topKFreqs = new int[k];
        int i = 0;
        for (int j = buckets.length - 1; j >= 0 && i < k; j--) {
            if (buckets[j] != null) {
                for (int num : buckets[j]) {
                    topKFreqs[i] = num;
                    i++;

                    if (i == k)
                        break;
                }
            }
        }

        return topKFreqs;
    }
}