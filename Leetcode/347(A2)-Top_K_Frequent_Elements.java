class TopKFrequentElementsA2 {
    //**
    Clarifications
    - list of k most freq and not kth element, right?
    - return in any order?
    - at least one element in the array? 
    - assume k is valid?

    approaches
        - FreqHashSet. create tuple for num->freq. sort it by freq. 
        create list of top k most freq and return that. 
            time: n + nlogn + k space: n + n + k
        
        - hashSet. create tuple for num->freq. MinHeap, store the k largest
        elements. return all those elements
            time: n + nlogk, space: n + k
        
        - quickselect. partition the array via a pivot as we iterate and return 
        the elements kth position to the end. 
            time: avg: O(n), worst: O(N^2). space: avg: O(1), worst O(n)

    tests 
        - regular test case
        - both heap arranging and not arranging

    [1 1 1 2 2 3], k = 2
    (1 -> 3, 3 -> 1, 2 -> 2, )
    MinHeap: (1|3, 2|1)
    */

    public class NumAndFreq {
        int num;
        int freq;
        public NumAndFreq(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        // create freq hashset
        HashMap<Integer, Integer> numToFreq = new HashMap<>();
        for(int num : nums){
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }

        // create heap
        PriorityQueue<NumAndFreq> minHeap = new PriorityQueue<NumAndFreq>((A, B) -> Integer.compare(A.freq, B.freq));
        for(int num : numToFreq.keySet()){
            NumAndFreq curr = new NumAndFreq(num, numToFreq.get(num));

            if(minHeap.size() < k){
                minHeap.add(curr);
            }else{
                if(curr.freq > minHeap.peek().freq){
                    minHeap.poll();
                    minHeap.add(curr);
                }
            }
        }

        // return top k frequent elements
        int[] res = new int[k];
        int i = 0;
        for(NumAndFreq curr : minHeap){
            res[i] = curr.num;
            i++;
        }
        
        return res;
    }
}